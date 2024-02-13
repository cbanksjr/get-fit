package com.exercisegenerator.backend.repositories;


import org.springframework.data.repository.CrudRepository;

import com.exercisegenerator.backend.models.Users;



public interface UsersRepo extends CrudRepository<Users, Long> {
    Users findByEmail(String email);
}
