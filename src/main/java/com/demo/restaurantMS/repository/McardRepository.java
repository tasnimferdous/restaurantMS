package com.demo.restaurantMS.repository;

import com.demo.restaurantMS.entity.Mcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface McardRepository extends JpaRepository<Mcard,Integer> {
}
