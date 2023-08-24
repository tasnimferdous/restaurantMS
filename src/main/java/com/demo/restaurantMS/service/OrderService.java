package com.demo.restaurantMS.service;

import com.demo.restaurantMS.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(int id);
    Order getOrder(int id);
}
