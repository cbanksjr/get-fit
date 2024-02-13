package com.exercisegenerator.backend.dto;


import com.exercisegenerator.backend.enums.RoleEnum;

import lombok.Data;

@Data
public class UsersDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private RoleEnum role;
}
