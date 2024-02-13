package com.exercisegenerator.backend.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exercisegenerator.backend.dto.UsersDTO;
import com.exercisegenerator.backend.enums.RoleEnum;
import com.exercisegenerator.backend.services.UsersService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UsersController extends BaseController {

    public UsersController(UsersService usersService) {
        super(usersService);
    }

    /*
     * allows admin to see all users
     */
    @GetMapping()
    public ResponseEntity<?> getAllUsers(HttpServletRequest request) {
        try {
            checkAccess(RoleEnum.ADMIN, request);
            return ResponseEntity.ok(usersService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    /*
     * allows admin to get users by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id, HttpServletRequest request) {
        try {
            checkAccess(RoleEnum.ADMIN, request);
            return ResponseEntity.ok(usersService.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * checks users email for password reset
     * @param userDTO
     * @return
     */
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestBody UsersDTO userDTO){
        try{
            return ResponseEntity.ok(usersService.getUser(userDTO.getEmail()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    /**
     * 
     * @param userDTO
     * @return
     */
    @PostMapping("/newuser")
    public ResponseEntity<?> createUser(@RequestBody UsersDTO userDTO) {
        try {
            return ResponseEntity.ok(usersService.createUser(userDTO));   
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Allows users to update their password
     * @param userDTO
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UsersDTO userDTO) {
        try {
            return ResponseEntity.ok(usersService.updateUser(userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * allows for deletion of user
     * @param id
     * @param request
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id, HttpServletRequest request) {
        try {
            usersService.deleteUser(id);
            UsersDTO user = usersService.getUserById(id);
            return ResponseEntity.ok(user);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{userId}/save/{exerciseId}")
    public ResponseEntity<?> saveExercises(@PathVariable long userId, @PathVariable long exerciseId, HttpServletRequest request) {
        try {
            usersService.saveUserExercise(userId, exerciseId); 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/{userId}/remove/{exerciseId}")
    public ResponseEntity<?> removeExercises(@PathVariable long userId, @PathVariable long exerciseId) {
        try {
            usersService.deleteUserExercise(userId, exerciseId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }
}
