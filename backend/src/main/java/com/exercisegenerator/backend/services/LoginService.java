package com.exercisegenerator.backend.services;

import com.exercisegenerator.backend.dto.UsersDTO;

public interface LoginService {

    void login(UsersDTO userDTO, long id);
}
