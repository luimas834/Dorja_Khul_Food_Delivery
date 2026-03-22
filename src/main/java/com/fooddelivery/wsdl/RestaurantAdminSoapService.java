package com.fooddelivery.wsdl;

import com.fooddelivery.dao.MenuItemDao;
import com.fooddelivery.dao.PaymentDao;
import com.fooddelivery.dao.RestaurantDao;
import com.fooddelivery.dao.ScheduleDao;
import com.fooddelivery.dao.RiderDao;
import com.fooddelivery.dao.DeliveryDao;
import com.fooddelivery.model.Payment;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://wsdl.fooddelivery.com/")
public class RestaurantAdminSoapService {
    private final RestaurantDao restaurantDao = new RestaurantDao();
    private final MenuItemDao menuItemDao = new MenuItemDao();
    private final ScheduleDao scheduleDao = new ScheduleDao();
    private final PaymentDao paymentDao = new PaymentDao();
    private final RiderDao riderDao = new RiderDao();
    private final DeliveryDao deliveryDao = new DeliveryDao();

    @WebMethod
    public void registerRestaurant(
            @WebParam(name="ownerId") int ownerId,
            @WebParam(name="name") String name,
            @WebParam(name="address") String address) throws Exception {
        restaurantDao.addRestaurant(ownerId, name, address);
    }

    @WebMethod
    public void addMenuItem(
            @WebParam(name="restaurantId") int restaurantId,
            @WebParam(name="name") String name,
            @WebParam(name="price") double price,
            @WebParam(name="quantity") int quantity,
            @WebParam(name="addons") String addons) throws Exception {
        menuItemDao.addMenuItem(restaurantId, name, price, quantity, addons);
    }

    @WebMethod
    public void setMenuAvailability(
            @WebParam(name="menuItemId") int menuItemId,
            @WebParam(name="available") boolean available) throws Exception {
        menuItemDao.updateAvailability(menuItemId, available);
    }

    @WebMethod
    public void setMenuQuantity(
            @WebParam(name="menuItemId") int menuItemId,
            @WebParam(name="quantity") int quantity) throws Exception {
        menuItemDao.updateQuantity(menuItemId, quantity);
    }

    @WebMethod
    public void setMenuAddons(
            @WebParam(name="menuItemId") int menuItemId,
            @WebParam(name="addons") String addons) throws Exception {
        menuItemDao.updateAddons(menuItemId, addons);
    }

    @WebMethod
    public void setSchedule(
            @WebParam(name="restaurantId") int restaurantId,
            @WebParam(name="openTime") String openTime,
            @WebParam(name="closeTime") String closeTime) throws Exception {
        scheduleDao.setSchedule(restaurantId, openTime, closeTime);
    }

    @WebMethod
    public List<Payment> getPaymentsByRestaurant(
            @WebParam(name="restaurantId") int restaurantId) throws Exception {
        return paymentDao.getPaymentsByRestaurant(restaurantId);
    }

    @WebMethod
    public void assignRiderToOrder(
            @WebParam(name="orderId") int orderId,
            @WebParam(name="riderId") int riderId) throws Exception {
        deliveryDao.createDelivery(orderId, riderId, "OUT_FOR_DELIVERY");
        riderDao.setAvailable(riderId, false);
    }
}