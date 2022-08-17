package com.ibm.restaurant.application.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.restaurant.domain.customer.Customer;
import com.ibm.restaurant.domain.customer.CustomerRepository;
import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.exception.NotFoundException;
import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.OrderStatus;
import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Service
public class OrdersService {

    @Autowired
    private IOrdersRepository iOrdersRepository;
    @Autowired
    private IMenuItemsRepository iMenuItemsRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public Orders createOrders(Long customerId, List<Long> menuItems){
        Orders orders = new Orders(OrderStatus.IN_PROGRESS);
        Customer customer = customerRepository.findById(customerId);
        if(customer == null && menuItems == null){
            throw new NotFoundException(String.format("Customer with id %s does not exist in the system! \n\"Menu item with id %s does not exist in the system!\"" , customerId, menuItems));
        }
        else if( customer == null && menuItems != null){
            throw new NotFoundException(String.format("Customer with id %s does not exist in the system!" , customerId));

        }
        else if( customer != null && menuItems == null){
            throw new NotFoundException(String.format("Menu item with id %s does not exist in the system" , menuItems));

        }
        else{
            orders.setCustomerId(customer);
            orders.setOrderTime(orders.getOrderTime());
            orders.setOrderStatus(OrderStatus.IN_PROGRESS);
            addMenuItemsToOrder(orders, menuItems);
            return iOrdersRepository.createOrder(orders);
        }
    }

    public HashSet<Orders> getOrdersList(){
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



    public Orders getOrdersById(Long ordersId){
        return iOrdersRepository.getOrderById(ordersId);
    }


    public void updateOrder(Long orderId, Orders orders) {
        List<Long> menuItems = new ArrayList<>();
        Orders ordersFromDB = getOrdersById(orderId);
        addMenuItemsToOrder(orders, menuItems);
        iOrdersRepository.updateOrder(ordersFromDB);
    }


    public void cancelOrder(Long ordersId, Orders orders) {
        Orders ordersFromDB = getOrdersById(ordersId);
        if(ordersFromDB.orderStatus.equals(OrderStatus.IN_PROGRESS)) {
            ordersFromDB.setOrderStatus(OrderStatus.CANCELED);
            iOrdersRepository.cancelOrder(ordersFromDB);
        }
        else if(ordersFromDB.orderStatus.equals(OrderStatus.IN_DELIVERY)) {
            String message = "The order is in delivery and cannot be canceled!";
            String code = "BAD_REQUEST";
            throw new BusinessException(message,code);
        }
        else if(ordersFromDB.orderStatus.equals(OrderStatus.DELIVERED)){
            String message = "The order was delivered and cannot be canceled!";
            String code = "BAD_REQUEST";
            throw new BusinessException(message,code);
        }
        else if(ordersFromDB.orderStatus.equals(OrderStatus.CANCELED)){
            String message = "The order is already canceled!";
            String code = "BAD_REQUEST";
            throw new BusinessException(message,code);
        }

    }

    public void readyToBeDeliveredOrder(Long ordersId, Orders orders) {
        Orders ordersFromDB = getOrdersById(ordersId);
        if(ordersFromDB.orderStatus.equals(OrderStatus.DELIVERED)){
            String message = "The order is already delivered!";
            String code = "BAD_REQUEST";
            throw new BusinessException(message,code);
        }
        else if(!ordersFromDB.orderStatus.equals(OrderStatus.IN_DELIVERY)){
            ordersFromDB.setOrderStatus(OrderStatus.IN_DELIVERY);
            iOrdersRepository.readyToBeDeliveredOrder(ordersFromDB);
        }

    }

    public void deliveredOrder(Long ordersId, Orders orders) {
        Orders ordersFromDB = getOrdersById(ordersId);
        ordersFromDB.setOrderStatus(OrderStatus.DELIVERED);
        iOrdersRepository.deliveredOrder(ordersFromDB);
    }

    public Orders getOrderPrice(Long ordersId){
        return iOrdersRepository.getOrderById(ordersId);
    }






}
