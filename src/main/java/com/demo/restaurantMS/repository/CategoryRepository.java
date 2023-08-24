package com.demo.restaurantMS.repository;

import com.demo.restaurantMS.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
