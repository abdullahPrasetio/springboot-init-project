package com.github.abdullahprasetio.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.github.abdullahprasetio.models.entities.Category;

/**
 * CategoryRepo
 */
public interface CategoryRepo extends CrudRepository<Category, Long>{

    
}