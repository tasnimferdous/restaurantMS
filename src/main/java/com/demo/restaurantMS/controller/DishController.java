package com.demo.restaurantMS.controller;

import com.demo.restaurantMS.entity.Category;
import com.demo.restaurantMS.entity.Dish;
import com.demo.restaurantMS.response.AllTheResponses;
import com.demo.restaurantMS.service.DishService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping(path = "/dishes")
    public List<Dish> getAllDishes(){
        return dishService.getAllDishes();
    }

    @PostMapping(path = "/dishes")
    public AllTheResponses createDish(@RequestBody Dish dish) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Dish newDish =  dishService.createDish(dish);

        return AllTheResponses.builder()
                .hasError(false)
                .content(objectMapper.writeValueAsString(newDish))
                .message("Dish created successfully!").build();

    }

    @PutMapping(path = "/dishes")
    public AllTheResponses updateDish(@RequestBody Dish dish) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Dish updatedDish = dishService.updateDish(dish);

        return AllTheResponses.builder()
                .hasError(false)
                .message("Successfully updated!")
                .content(objectMapper.writeValueAsString(updatedDish))
                .build();
    }

    @DeleteMapping(path = "dishes/{id}")
    public void deleteDish(@PathVariable int id){
        dishService.deleteDish(id);
    }

    @GetMapping(path = "dishes/{id}")
    public Dish getDish(@PathVariable int id){
        return dishService.getDish(id);
    }

    @GetMapping(path = "/dishesByCategory/{id}")
    public List<Dish> getDishesByCategory(@PathVariable Category id){
        return dishService.getDishesByCategory(id);
    }
}
