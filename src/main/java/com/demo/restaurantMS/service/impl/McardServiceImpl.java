package com.demo.restaurantMS.service.impl;

import com.demo.restaurantMS.entity.Category;
import com.demo.restaurantMS.entity.Mcard;
import com.demo.restaurantMS.repository.CategoryRepository;
import com.demo.restaurantMS.repository.McardRepository;
import com.demo.restaurantMS.service.McardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class McardServiceImpl implements McardService {
    private final McardRepository mcardRepository;
    private final CategoryRepository categoryRepository;

    public McardServiceImpl(McardRepository mcardRepository, CategoryRepository categoryRepository) {
        this.mcardRepository = mcardRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Mcard> getAllMcards() {
        return mcardRepository.findAll();
    }

    @Override
    public Mcard createMcard(Mcard mcard){
        setValues(mcard);
        return mcardRepository.save(mcard);
    }


    @Override
    public Mcard updateMcard(Mcard mcard){
        if(mcard.getId()==0){
            return new Mcard();
        }
        setValues(mcard);
        return mcardRepository.save(mcard);
    }

    @Override
    public void deleteMcard(int id) {
        mcardRepository.deleteById(id);
    }

    @Override
    public Mcard getMcard(int id) {
        return mcardRepository.findById(id).isPresent() ? mcardRepository.findById(id).get() : null;
    }

    public void setValues(Mcard mcard){
        for (Category category: mcard.getCategories()){
            Optional<Category> getCategory = categoryRepository.findById(category.getId());
            if(getCategory.isPresent()){
                category.setName(getCategory.get().getName());
            }else {
                log.info("Category not found");
            }
        }
    }
}
