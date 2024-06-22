package com.github.abdullahprasetio.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.abdullahprasetio.models.entities.Category;

/**
 * CategoryRepo
 */
public interface CategoryRepo extends PagingAndSortingRepository<Category, Long>,CrudRepository<Category, Long>{
    Page<Category> findByNameContains(String name,Pageable pageable);

    
}