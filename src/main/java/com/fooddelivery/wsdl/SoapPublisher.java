package com.fooddelivery.wsdl;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import jakarta.xml.ws.Endpoint;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SoapPublisher {
    public static void publish() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            Endpoint restaurantEndpoint = Endpoint.create(new RestaurantSoapService());
            Endpoint orderEndpoint = Endpoint.create(new OrderSoapService());

            HttpContext restaurantContext = server.createContext("/RestaurantService");
            HttpContext orderContext = server.createContext("/OrderService");

            Filter corsFilter = new CorsFilter();
            restaurantContext.getFilters().add(corsFilter);
            orderContext.getFilters().add(corsFilter);

            restaurantEndpoint.publish(restaurantContext);
            orderEndpoint.publish(orderContext);

            server.start();

            System.out.println("Server started with CORS support!");
            System.out.println("RestaurantService WSDL: http://localhost:8080/RestaurantService?wsdl");
            System.out.println("OrderService WSDL: http://localhost:8080/OrderService?wsdl");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static class CorsFilter extends Filter {
        @Override
        public String description() {
            return "Handles CORS Preflight requests for JAX-WS";
        }

        @Override
        public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");

            if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                exchange.sendResponseHeaders(204, -1);
                return; 
            }
            chain.doFilter(exchange);
        }
    }
}