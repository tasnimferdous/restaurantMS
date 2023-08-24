package com.demo.restaurantMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DISHES")
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne
//    @Column(name = "category")
    private Category category;


}
