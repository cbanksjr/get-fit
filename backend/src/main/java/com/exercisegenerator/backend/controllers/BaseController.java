package com.exercisegenerator.backend.controllers;


import com.exercisegenerator.backend.dto.UsersDTO;
import com.exercisegenerator.backend.enums.RoleEnum;
import com.exercisegenerator.backend.services.UsersService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

/*
 * Controller to check if password and email exist in database
 */
@AllArgsConstructor
public abstract class BaseController {
    
    protected UsersService usersService;

    protected boolean login(String email, String password, HttpServletResponse response) {
        logout(response);
        UsersDTO user = usersService.getUser(email);
        boolean returnValue = false;
        if (user != null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
            Cookie jwtTokenCookie = new Cookie("username", "" + user.getUserName());
            Cookie passwordCookie = new Cookie("password", user.getPassword());
            Cookie roleCookie = new Cookie("role", "" + user.getRole());
            response.addCookie(roleCookie);
            response.addCookie(passwordCookie);
            response.addCookie(jwtTokenCookie);
            returnValue = true;
        }
        return returnValue;
    }

    /*
     * Resets cookies after logout
     */
    protected void logout(HttpServletResponse response) {
        Cookie jwtTokenCookie = new Cookie("username", "null");
        Cookie passwordCookie = new Cookie("password", "null");
        Cookie roleCookie = new Cookie("role", "null");
        jwtTokenCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);
        roleCookie.setMaxAge(0);
        response.addCookie(roleCookie);
        response.addCookie(passwordCookie);
        response.addCookie(jwtTokenCookie);
    }

    /*
     * Checks for user role
     */
     protected void checkAccess(RoleEnum userRole, HttpServletRequest request) throws Exception{
        RoleEnum role = getUserRole(request);
        if(userRole.compareTo(role) > 0){
            throw new Exception("Unauthorized Access");
        }
    }

    protected RoleEnum getUserRole(HttpServletRequest request) throws Exception {
        RoleEnum role = RoleEnum.NOTHING;
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            throw new Exception("Please log in");
        }
        for(int i = 0; i < cookies.length; i++){
            if(cookies[i].getName().equals("role")){
                String value = cookies[i].getValue();
                if(!value.equals("null")){
                    role = RoleEnum.valueOf(value);
                }
                break;
            }
        }
        return role;
    }
}
