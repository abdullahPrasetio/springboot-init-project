package com.github.abdullahprasetio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class AppUserDto {
    @NotEmpty(message = "Full Name is required")
    private String fullName;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "App User Role is required")
    private String appUserRole;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAppUserRole() {
        return appUserRole;
    }
    public void setAppUserRole(String appUserRole) {
        this.appUserRole = appUserRole;
    }
}
