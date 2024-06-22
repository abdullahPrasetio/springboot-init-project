package com.github.abdullahprasetio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abdullahprasetio.models.entities.Supplier;
import com.github.abdullahprasetio.models.repos.SupplierRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier supplier) {
        return this.supplierRepo.save(supplier);
    }

    public Supplier findOne(Long id) {
        var supplier = this.supplierRepo.findById(id);
        if (!supplier.isPresent()) {
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll() {
        return this.supplierRepo.findAll();
    }

    public void removeOne(Long id) {
        this.supplierRepo.deleteById(id);
    }

    public Supplier findByEmail(String email) {
        return this.supplierRepo.findByEmail(email);
    }

    public List<Supplier> findByName(String name) {
        return this.supplierRepo.findByNameContainsOrderByIdDesc(name);
    }

    public List<Supplier> findByNameStartWith(String prefix) {
        return this.supplierRepo.findByNameStartingWith(prefix);
    }

    public List<Supplier> findByNameOrEmailContains(String name, String email) {
        return this.supplierRepo.findByNameContainsOrEmailContains(name,email);
    }
}
