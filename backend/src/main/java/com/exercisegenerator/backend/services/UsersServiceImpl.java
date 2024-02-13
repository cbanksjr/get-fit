package com.exercisegenerator.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.exercisegenerator.backend.dto.UsersDTO;
import com.exercisegenerator.backend.enums.RoleEnum;
import com.exercisegenerator.backend.models.Exercise;
import com.exercisegenerator.backend.models.Users;
import com.exercisegenerator.backend.repositories.ExerciseRepo;
import com.exercisegenerator.backend.repositories.UsersRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepo usersRepo;
    private ExerciseRepo exerciseRepo;
    private ModelMapper modelMapper;

    /**
     * checks if user is in repository
     */
    @Override
    public UsersDTO getUserById(long id) {
        Users users = usersRepo.findById(id).orElse(null);
        return (users != null) ? modelMapper.map(users, UsersDTO.class) : null;
    }

    /**
     * checks existing user by email
     */
    @Override
    public UsersDTO getUser(String email) {
        Users users = usersRepo.findByEmail(email);
        return (users != null) ? modelMapper.map(users, UsersDTO.class) : null;
    }

    /**
     * gets all users
     */
    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> allUsers = (List<Users>) usersRepo.findAll();
        return allUsers.stream()
                .map(users -> modelMapper.map(users, UsersDTO.class))
                .collect(Collectors.toList());

    }

    /**
     * If user doesn't exist, allows for creation of user
     */
    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {
        Users users = modelMapper.map(usersDTO, Users.class);
        if (users != null) {
            users.setRole(RoleEnum.USER);
            usersRepo.save(users);
            return modelMapper.map(users, UsersDTO.class);
        } else {
            throw new RuntimeException("Failed to map UsersDTO to Users.");
        }
    }

    /**
     * checks if user exists by email and allows password update for user
     */
    @Override
    public UsersDTO updateUser(UsersDTO usersDTO) {
        Users existingUser = usersRepo.findByEmail(usersDTO.getEmail());

        if(existingUser != null) {
            existingUser.setPassword(usersDTO.getPassword());
            usersRepo.save(existingUser);

            return modelMapper.map(existingUser, UsersDTO.class);
        } else {
            throw new RuntimeException("User not found with email: " + usersDTO.getEmail());
        }
    }

    @Override
    public void deleteUser(long id) {
        usersRepo.deleteById(id);
    }

    @Override
    public void exerciseRelationship(Users user, Exercise exercise) {
        user.getExercises().add(exercise);
        exercise.getUser().add(user);
        usersRepo.save(user);
    }

    @Override
    public void saveUserExercise(long userId, long exerciseId) {
        Optional<Exercise> exercises = exerciseRepo.findById(exerciseId);
        Optional<Users> users = usersRepo.findById(userId);

        if (users.isPresent() && exercises.isPresent()) {
            exerciseRelationship(users.get(), exercises.get());
        }
    }

    @Override
    public void deleteUserExercise(long userId, long exerciseId) {
        Optional<Exercise> exercises = exerciseRepo.findById(exerciseId);
        Optional<Users> users = usersRepo.findById(userId);

        if (users.isPresent() && exercises.isPresent()) {
            Users user = users.get();
            Exercise exercise = exercises.get();

            user.getExercises().remove(exercise);
            exercise.getUser().remove(user);
            usersRepo.save(user);

        }

    }
}