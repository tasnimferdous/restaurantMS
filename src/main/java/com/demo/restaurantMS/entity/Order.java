package com.demo.restaurantMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ORDERS")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany
//    @JoinColumn(name = "dishes")
    private List<Dish> dishes;

    @ManyToMany
//    @JoinColumn(name = "customer")
    private List<Customer> customer;

    @Column(name = "total_amount")
    private double totalAmount;
}
