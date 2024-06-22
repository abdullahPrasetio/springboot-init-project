package com.github.abdullahprasetio.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.abdullahprasetio.dto.ResponseData;
import com.github.abdullahprasetio.dto.SupplierDto;
import com.github.abdullahprasetio.models.entities.Supplier;
import com.github.abdullahprasetio.services.SupplierService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    // This is a controller class
    // This class is used to handle the request from the client

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Supplier>> create(@Valid @RequestBody SupplierDto supplierDto,Errors errors){
        // var responseData= new ResponseData<Supplier>();
        ResponseData<Supplier> responseData= new ResponseData<>();
        if(errors.hasErrors()){
            for(var error:errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            // responseData.getMessages().add("Invalid input");
            return ResponseEntity.badRequest().body(responseData);
        }

        // Cara manual
        // Supplier supplier = new Supplier();
        // supplier.setName(supplierDto.getName());
        // supplier.setAddress(supplierDto.getAddress());
        // supplier.setEmail(supplierDto.getEmail());

        Supplier supplier = modelMapper.map(supplierDto,Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Supplier> findAll() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable Long id) {
        return supplierService.findOne(id);
    }

    @PutMapping()
    public ResponseEntity<ResponseData<Supplier>> update(@Valid @RequestBody SupplierDto supplierDto,Errors errors){
        // var responseData= new ResponseData<Supplier>();
        ResponseData<Supplier> responseData= new ResponseData<>();
        if(errors.hasErrors()){
            for(var error:errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            // responseData.getMessages().add("Invalid input");
            return ResponseEntity.badRequest().body(responseData);
        }

        // Cara manual
        // Supplier supplier = new Supplier();
        // supplier.setName(supplierDto.getName());
        // supplier.setAddress(supplierDto.getAddress());
        // supplier.setEmail(supplierDto.getEmail());

        Supplier supplier = modelMapper.map(supplierDto,Supplier.class);

        responseData.setStatus(true);
        responseData.setPayload(supplierService.save(supplier));
        return ResponseEntity.ok(responseData);
    }
    
}
