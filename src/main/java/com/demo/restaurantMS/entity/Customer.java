package com.demo.restaurantMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CUSTOMERS")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
}
