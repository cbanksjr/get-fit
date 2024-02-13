package com.exercisegenerator.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.exercisegenerator.backend.dto.UsersDTO;
import com.exercisegenerator.backend.models.Users;
import com.exercisegenerator.backend.services.UsersService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class LoginController extends BaseController {

    protected LoginController(UsersService usersService) {
        super(usersService);
    }

    /*
     * allows user login based upon user credentials being checked in repsository
     */
    @PostMapping("/login")
    public ResponseEntity<?> postLogin(@RequestBody Users users, HttpServletResponse response) {
        if (this.login(users.getEmail(), users.getPassword(), response)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Login");
    }
    
    /*
     * Allows user to logout
     */
    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpServletResponse response){
        this.logout(response);
        return ResponseEntity.ok("Logout Successful");
    }

    /*
     * Gets all users
     */
    @GetMapping("/user")
    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok(usersService.getAllUsers());
    }
}
