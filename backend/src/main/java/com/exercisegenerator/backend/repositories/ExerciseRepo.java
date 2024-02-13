package com.exercisegenerator.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exercisegenerator.backend.models.Exercise;

public interface ExerciseRepo extends CrudRepository<Exercise, Long>{

    
}
