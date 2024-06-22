package com.github.abdullahprasetio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.abdullahprasetio.models.entities.Category;
import com.github.abdullahprasetio.models.repos.CategoryRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    public Category findOne(Long id) {
        var category = this.categoryRepo.findById(id);
        if (!category.isPresent()) {
            return null;
        }
        return category.get();
    }

    public Iterable<Category> findAll() {
        return this.categoryRepo.findAll();
    }

    public void removeOne(Long id) {
        this.categoryRepo.deleteById(id);
    }

    public Iterable<Category> findByNameContains(String name,Pageable pageable) {
        return this.categoryRepo.findByNameContains(name,pageable);
    }

    public Iterable<Category> saveBatch(Iterable<Category> categories) {    
        return this.categoryRepo.saveAll(categories);
    }
}
