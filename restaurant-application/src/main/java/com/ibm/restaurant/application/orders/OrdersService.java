package com.ibm.restaurant.application.orders;

import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class OrdersService {

    @Autowired
    private IOrdersRepository iOrdersRepository;
    @Autowired
    private IMenuItemsRepository iMenuItemsRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public Orders createOrders(final Long customerId, List<Long> menuItems){
        Orders orders = new Orders(OrderStatus.IN_PROGRESS);
       // Customer customer = customerRepository.findById(customerId);
        //orders.setOrderId(customerId);
        addMenuItemsToOrder(orders, menuItems);
       return iOrdersRepository.createOrder(orders);
    }

    public List<Orders> getOrdersList(){
        return iOrdersRepository.getOrdersList();
    }

    private void addMenuItemsToOrder(Orders orders, List<Long> menuItems) {
        List<MenuItems> menuItemsFromDb = new ArrayList<>();

        for(Long item : menuItems) {
            MenuItems menu = iMenuItemsRepository.getMenuItems(item);
            menuItemsFromDb.add(menu);
        }
        menuItemsFromDb.forEach(item -> orders.addMenuItem(item));
    }














/*
    public Orders getOrdersById(Long ordersId){
        return iOrdersRepository.getOrdersById(ordersId);
    }

    public Orders getOrdersPrice(Double ordersPrice){
        return iOrdersRepository.getOrdersPrice(ordersPrice);
    }


    public void cancelOrder(Long ordersId, Orders orders) {
        Orders ordersFromDB = getOrdersById(ordersId);
        //ordersFromDB.setOrderStatus(orders.getOrderStatus());
       // ordersFromDB.setOrderStatus((OrderStatus.CANCELED));
        iOrdersRepository.cancelOrder(ordersFromDB);

    }
*/

}
