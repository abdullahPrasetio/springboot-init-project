package com.github.abdullahprasetio.services;

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
}
