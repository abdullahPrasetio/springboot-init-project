package com.github.abdullahprasetio.controllers;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.hibernate.query.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.abdullahprasetio.dto.CategoryDto;
import com.github.abdullahprasetio.dto.ResponseData;
import com.github.abdullahprasetio.dto.SearchDto;
import com.github.abdullahprasetio.models.entities.Category;
import com.github.abdullahprasetio.services.CategoryService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Category>> create(@Valid @RequestBody CategoryDto categoryDto, Errors errors) {
        ResponseData<Category> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (var error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            // responseData.getMessages().add("Invalid input");
            return ResponseEntity.badRequest().body(responseData);
        }

        Category category = modelMapper.map(categoryDto, Category.class);

        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id") Long id) {
        return categoryService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Category>> update(@Valid @RequestBody CategoryDto categoryDto, Errors errors) {
        ResponseData<Category> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (var error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            // responseData.getMessages().add("Invalid input");
            return ResponseEntity.badRequest().body(responseData);
        }

        Category category = modelMapper.map(categoryDto, Category.class);

        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/search/{size}/{page}")
    public Iterable<Category> findByName(@RequestBody SearchDto searchDto, @PathVariable("size") int size, @PathVariable("page") int page) {

        Pageable pageable = PageRequest.of(page, size);
        return categoryService.findByNameContains(searchDto.getSearchKey(), pageable);
    }

    @PostMapping("/search/{size}/{page}/{sort}")
    public Iterable<Category> findByName(
        @RequestBody SearchDto searchDto, 
        @PathVariable("size") int size, @PathVariable("page") int page, 
        @PathVariable("sort") String sort){

        Pageable pageable = PageRequest.of(page, size,Sort.by("id"));

        if (sort.equalsIgnoreCase("desc")) {
            pageable = PageRequest.of(page, size,Sort.by("id").descending());
            
        }
        return categoryService.findByNameContains(searchDto.getSearchKey(), pageable);
    }
    // With validation
    // public ResponseEntity<ResponseData<Iterable<Category>>> createBatch(@RequestBody Iterable<CategoryDto> categoryDtos, Errors errors) {
    //     ResponseData<Iterable<Category>> responseData = new ResponseData<>();
    //     if (errors.hasErrors()) {
    //         for (var error : errors.getAllErrors()) {
    //             responseData.getMessages().add(error.getDefaultMessage());
    //         }
    //         responseData.setStatus(false);
    //         // responseData.getMessages().add("Invalid input");
    //         return ResponseEntity.badRequest().body(responseData);
    //     }

    //     Iterable<Category> categories = modelMapper.map(categoryDtos, Iterable.class);

    //     responseData.setStatus(true);
    //     responseData.setPayload(categoryService.saveBatch(categories));
    //     return ResponseEntity.ok(responseData);
    // }

    @PostMapping("/batch")
    public ResponseEntity<ResponseData<Iterable<Category>>> createBatch(@RequestBody Category[] categories) {
        ResponseData<Iterable<Category>> responseData = new ResponseData<>();

        responseData.setStatus(true);
        responseData.setPayload(categoryService.saveBatch(Arrays.asList(categories)));
        return ResponseEntity.ok(responseData);
    }
    
}
