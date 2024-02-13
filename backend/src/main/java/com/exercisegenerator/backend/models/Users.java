package com.exercisegenerator.backend.models;

import java.util.List;


import com.exercisegenerator.backend.enums.RoleEnum;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private RoleEnum role = RoleEnum.USER;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_exercises", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private List<Exercise> exercises;

    public Users(String firstName, String lastName, String userName, String password, String email, RoleEnum role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

}
