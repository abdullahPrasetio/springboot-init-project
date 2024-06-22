package com.github.abdullahprasetio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abdullahprasetio.models.entities.Product;
import com.github.abdullahprasetio.models.entities.Supplier;
import com.github.abdullahprasetio.models.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product) {
        return this.productRepo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    public Iterable<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findOne(productId);
        if (product == null) {
            throw new RuntimeException("Product with id " + productId + " not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }


    public Product findByProductName(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> findByProductNameLike(String name) {
        return productRepo.findByNameLike("%"+name+"%");
    }

    public List<Product> findByProductCategory(Long id) {
        return productRepo.findByCategoryId(id);
    }

    public List<Product> findBySupplier(Long supplierId) {
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null) {
            return new ArrayList<Product>();
        }
        return productRepo.findBySupplier(supplier);
    }
    
}
