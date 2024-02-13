package com.exercisegenerator.backend.models;

import java.util.List;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String muscle;
    private String equipment;
    private String difficulty;
    @Lob
    private String instructions;

    
    @ManyToMany(mappedBy = "exercises")
    private List<Users> user;

    public Exercise(String name, String type, String muscle, String equipment, String difficulty, String instructions) {
        this.name = name;
        this.type = type;
        this.muscle = muscle;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.instructions = instructions;
    }

}
