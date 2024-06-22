package com.github.abdullahprasetio.models.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.github.abdullahprasetio.models.entities.AppUser;

/**
 * AppUserRepo
 */
public interface AppUserRepo extends CrudRepository<AppUser, Long>{
    Optional<AppUser> findByEmail(String email);
}