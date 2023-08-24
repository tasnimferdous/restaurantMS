package com.demo.restaurantMS.service;

import com.demo.restaurantMS.entity.Category;
import com.demo.restaurantMS.entity.Dish;
import com.demo.restaurantMS.response.AllTheResponses;

import java.util.List;

public interface DishService {
    public List<Dish> getAllDishes();
    public Dish createDish(Dish dish) throws Exception;
    public Dish updateDish(Dish dish) throws Exception;
    public void deleteDish(int id);
    public Dish getDish(int id);

    List<Dish> getDishesByCategory(Category id);
}
