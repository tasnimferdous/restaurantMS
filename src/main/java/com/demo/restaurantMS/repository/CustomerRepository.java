package com.demo.restaurantMS.repository;

import com.demo.restaurantMS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
