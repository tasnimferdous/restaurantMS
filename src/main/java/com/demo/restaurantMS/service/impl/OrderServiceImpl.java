package com.demo.restaurantMS.service.impl;

import com.demo.restaurantMS.entity.Customer;
import com.demo.restaurantMS.entity.Dish;
import com.demo.restaurantMS.entity.Order;
import com.demo.restaurantMS.repository.CustomerRepository;
import com.demo.restaurantMS.repository.DishRepository;
import com.demo.restaurantMS.repository.OrderRepository;
import com.demo.restaurantMS.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, DishRepository dishRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        setValues(order);
        double totalAmount = getTotalAmount(order);
        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        setValues(order);
        double totalAmount = getTotalAmount(order);
        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        if(orderRepository.findById(id).isPresent()){
            orderRepository.deleteById(id);
        }
        else log.info("Order not found!");
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.findById(id).isPresent()?orderRepository.findById(id).get():null;
    }

    public double getTotalAmount(Order order){
        double totalAmount = 0;
        for(Dish dish: order.getDishes()){
            totalAmount += dish.getPrice();
        }
        return totalAmount;
    }

    public void setValues(Order order){
        for(Dish dish: order.getDishes()){
            Optional<Dish> getDish = dishRepository.findById(dish.getId());
            if(getDish.isPresent()){
                dish.setName(getDish.get().getName());
                dish.setDescription(getDish.get().getDescription());
                dish.setPrice(getDish.get().getPrice());
                dish.setCategory(getDish.get().getCategory());
            }else{
                log.info("Dish not found");
            }
        }

        for(Customer customer: order.getCustomer()){
            Optional<Customer> getCustomer = customerRepository.findById(customer.getId());
            if (getCustomer.isPresent()){
                customer.setName(getCustomer.get().getName());
                customer.setEmail(getCustomer.get().getEmail());
            }
        }
    }
}
