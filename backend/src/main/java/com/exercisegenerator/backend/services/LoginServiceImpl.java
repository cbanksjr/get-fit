package com.exercisegenerator.backend.services;

import org.springframework.stereotype.Service;

import com.exercisegenerator.backend.dto.UsersDTO;
import com.exercisegenerator.backend.repositories.UsersRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService  {

    private UsersRepo usersRepo;
    
    /**
     * gets information and based upon that info allows login access or not
     */
    @Override
    public void login(UsersDTO usersDTO, long id) {
        usersRepo.findById(id);
        if(id == usersDTO.getId()){
            usersDTO.getEmail();
            usersDTO.getPassword();
            usersDTO.getRole();
        }
    }
    
}
