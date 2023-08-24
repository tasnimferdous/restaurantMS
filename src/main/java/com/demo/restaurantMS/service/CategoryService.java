package com.demo.restaurantMS.service;

import com.demo.restaurantMS.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategory(int id);
}
