package com.github.abdullahprasetio.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.abdullahprasetio.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findByNameContains(String name);
}
