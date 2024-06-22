package com.github.abdullahprasetio.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.abdullahprasetio.models.entities.Supplier;


/**
 * SupplierRepo
 */
public interface SupplierRepo extends CrudRepository<Supplier, Long>{
    Supplier findByEmail(String email);

    List<Supplier> findByNameContainsOrderByIdDesc(String name);


    List<Supplier> findByNameStartingWith(String prefix);

    List<Supplier> findByNameEndsWith(String name);

    List<Supplier> findByNameContainsOrEmailContains(String name,String email);
    
}