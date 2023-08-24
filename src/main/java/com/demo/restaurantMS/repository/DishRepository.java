package com.demo.restaurantMS.repository;

import com.demo.restaurantMS.entity.Category;
import com.demo.restaurantMS.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {
    List<Dish> findByCategory(Category id);
}
