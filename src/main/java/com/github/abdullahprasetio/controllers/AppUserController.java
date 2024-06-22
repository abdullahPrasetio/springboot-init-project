package com.github.abdullahprasetio.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.abdullahprasetio.dto.AppUserDto;
import com.github.abdullahprasetio.dto.ResponseData;
import com.github.abdullahprasetio.models.entities.AppUser;
import com.github.abdullahprasetio.services.AppUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@Valid @RequestBody AppUserDto appUserDto,Errors errors) {
        ResponseData<AppUser> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (var error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            return ResponseEntity.badRequest().body(responseData);
        }
        AppUser appUser = modelMapper.map(appUserDto, AppUser.class);
        System.out.println(appUserDto);
        AppUser registeredAppUser = this.appUserService.registerAppUser(appUser);
        responseData.setStatus(true);
        responseData.getMessages().add("User registered");
        responseData.setPayload(registeredAppUser);
        return ResponseEntity.ok(responseData);
    }
    
}
