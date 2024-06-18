package com.github.abdullahprasetio.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.github.abdullahprasetio.models.entities.Product;
import com.github.abdullahprasetio.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProductController
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping()
    public Iterable<Product> findAll(@RequestParam(required = false) String name
    // ,@RequestParam(required = false) String desc
    ) {
        System.out.println("Name : " + name);
        // System.out.println("Desc : " + desc);
        if (name != null) {
            return productService.findByName(name);
        }
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    @PutMapping()
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        productService.removeOne(id);
    }

}