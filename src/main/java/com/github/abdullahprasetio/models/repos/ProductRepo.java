package com.github.abdullahprasetio.models.repos;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.github.abdullahprasetio.models.entities.Product;
import com.github.abdullahprasetio.models.entities.Supplier;

import jakarta.websocket.server.PathParam;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Iterable<Product> findByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByNameLike(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findByCategoryId(@PathParam("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    public List<Product>findBySupplier(@PathParam("supplier") Supplier supplier);
}
