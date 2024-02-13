package com.exercisegenerator.backend.services;

import com.exercisegenerator.backend.dto.UsersDTO;
import java.util.*;


import com.exercisegenerator.backend.models.Exercise;
import com.exercisegenerator.backend.models.Users;

public interface UsersService {

     UsersDTO getUser(String email);

     UsersDTO createUser(UsersDTO usersDTO);

     UsersDTO updateUser(UsersDTO usersDTO);

     void deleteUser(long id);

     void exerciseRelationship(Users user, Exercise exercise);

     void saveUserExercise(long userId, long exerciseId);

     void deleteUserExercise(long userId, long exerciseId);

     UsersDTO getUserById(long id);

     List<UsersDTO> getAllUsers();

}
