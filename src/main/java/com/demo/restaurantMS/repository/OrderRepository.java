package com.demo.restaurantMS.repository;

import com.demo.restaurantMS.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
