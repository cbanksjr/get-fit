package com.exercisegenerator.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.exercisegenerator.backend.enums.RoleEnum;
import com.exercisegenerator.backend.models.Users;
import com.exercisegenerator.backend.repositories.UsersRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Populator implements CommandLineRunner {
    
    private UsersRepo usersRepo;

    @Override
    public void run(String... args) throws Exception {
        Users user1 = new Users("Bob", "Villa", "bobv21", "bobspassword", "bobv@gmail.com", RoleEnum.USER);
		usersRepo.save(user1);
    }

    
}
