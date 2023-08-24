package com.demo.restaurantMS.service.impl;

import com.demo.restaurantMS.entity.Category;
import com.demo.restaurantMS.entity.Dish;
import com.demo.restaurantMS.repository.DishRepository;
import com.demo.restaurantMS.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish createDish(Dish dish) throws Exception{
        if(dish.getCategory() == null || dish.getName() == null || dish.getPrice() == 0){
            throw new Exception("Name, Price or Category can't be null!");
        }
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish dish) throws Exception{
        if (dish.getId() == 0 || dish.getCategory() == null || dish.getName() == null || dish.getPrice() == 0){
            throw new Exception("Id, Name, Price or Category can't be null!");
        }
        return dishRepository.save(dish);
    }




    @Override
    public void deleteDish(int id) {
        dishRepository.deleteById(id);
    }

    @Override
    public Dish getDish(int id) {
        Optional<Dish> dish = dishRepository.findById(id);
        return dish.isPresent()?dish.get():null;
    }

    @Override
    public List<Dish> getDishesByCategory(Category id) {
        List<Dish> dishes = dishRepository.findByCategory(id);
        if (dishes.isEmpty()){
            return null;
        }
        return dishes;
    }

}
