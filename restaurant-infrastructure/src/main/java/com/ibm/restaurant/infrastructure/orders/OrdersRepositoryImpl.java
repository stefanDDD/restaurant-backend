package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class OrdersRepositoryImpl implements IOrdersRepository {

    private Set<Orders> ordersSet = new HashSet<>();

    @Override
    public void createOrder(Orders orders) {
        ordersSet.add(orders);
        for(Orders orders1: ordersSet){

            System.out.println("Order: "+orders1.toString());
        }

    }

    @Override
    public Orders getOrdersById(Long orderId) {
        List<Orders> orders = new ArrayList<>(ordersSet);
        for(Orders order: orders){
            if(orderId.equals(order.getOrderId())){

                return order;
            }
        }
        return null;
    }

    @Override
    public Orders getOrdersPrice(Double ordersPrice) {
        return null;
    }

    @Override
    public HashSet<Orders> getOrdersList() {
        return new HashSet<>(ordersSet);
    }

    @Override
    public Orders cancelOrder(Long ordersId, Order orderStatus) {
        List<Orders> orders = new ArrayList<>(ordersSet);
        return null;
    }


}
