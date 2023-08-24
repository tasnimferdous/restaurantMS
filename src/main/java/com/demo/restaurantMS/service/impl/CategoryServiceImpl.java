package com.demo.restaurantMS.service.impl;

import com.demo.restaurantMS.entity.Category;
import com.demo.restaurantMS.repository.CategoryRepository;
import com.demo.restaurantMS.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategory(int id) {
        return categoryRepository.findById(id).isPresent() ? categoryRepository.findById(id).get() : null;
    }
}
