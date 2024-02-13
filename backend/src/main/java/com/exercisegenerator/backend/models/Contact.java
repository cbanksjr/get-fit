package com.exercisegenerator.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Contact {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    private String email;
    private String message;
    
    public Contact(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    
}
