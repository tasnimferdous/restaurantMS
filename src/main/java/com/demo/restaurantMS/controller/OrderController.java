package com.demo.restaurantMS.controller;

import com.demo.restaurantMS.entity.Order;
import com.demo.restaurantMS.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping(path = "/orders")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping(path = "/orders")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping(path = "/orders/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }

    @GetMapping(path = "/orders/{id}")
    public Order getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }
}
