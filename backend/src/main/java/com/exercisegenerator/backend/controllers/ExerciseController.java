package com.exercisegenerator.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.exercisegenerator.backend.services.ExerciseDifficultyService;
import com.exercisegenerator.backend.services.ExerciseMuscleGroupService;
import com.exercisegenerator.backend.services.ExerciseTypeService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Accesses each api and returns the info for that api when called
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private ExerciseTypeService exerciseTypeService;
    private ExerciseMuscleGroupService exerciseMuscleGroupService;
    private ExerciseDifficultyService exerciseDifficultyService;


    @GetMapping("/type/cardio")
    public ResponseEntity<?> getCardioWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.cardio());
    }

    @GetMapping("/type/olympic-lift")
    public ResponseEntity<?> getOlympicWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.olympLifting());
    }

    @GetMapping("/type/plyometrics")
    public ResponseEntity<?> getPlyometricWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.plyometrics());
    }

    @GetMapping("/type/powerlifting")
    public ResponseEntity<?> getPowerLiftingWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.powerLifting());
    }

    @GetMapping("/type/strength")
    public ResponseEntity<?> getStrengthWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.strength());
    }

    @GetMapping("/type/stretching")
    public ResponseEntity<?> getStretchingWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.stretching());
    }

    @GetMapping("/type/strongman")
    public ResponseEntity<?> getStrongmanWorkouts() {
        return ResponseEntity.ok(exerciseTypeService.strongMan());
    }

    /*
     * Muscle groups
     */
    @GetMapping("/musclegroup/abdominals")
    public ResponseEntity<?> getAbdominalsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.abdominals());
    }

    @GetMapping("/musclegroup/abductors")
    public ResponseEntity<?> getAbductorsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.abductors());
    }

    @GetMapping("/musclegroup/biceps")
    public ResponseEntity<?> getBicepsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.biceps());
    }

    @GetMapping("/musclegroup/calves")
    public ResponseEntity<?> getCalvesWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.calves());
    }

    @GetMapping("/musclegroup/chest")
    public ResponseEntity<?> getChestWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.chest());
    }

    @GetMapping("/musclegroup/forearms")
    public ResponseEntity<?> getForearmsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.forearms());
    }

    @GetMapping("/musclegroup/glutes")
    public ResponseEntity<?> getGlutessWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.glutes());
    }

    @GetMapping("/musclegroup/hamstrings")
    public ResponseEntity<?> getHamstringsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.hamstrings());
    }

    @GetMapping("/musclegroup/lats")
    public ResponseEntity<?> getLatsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.lats());
    }

    @GetMapping("/musclegroup/lowerback")
    public ResponseEntity<?> getLowerBackWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.lowerBack());
    }

    @GetMapping("/musclegroup/middleback")
    public ResponseEntity<?> getMiddelBackWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.middleBack());
    }

    @GetMapping("/musclegroup/neck")
    public ResponseEntity<?> getNeckWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.neck());
    }

    @GetMapping("/musclegroup/quads")
    public ResponseEntity<?> getQuadsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.quadriceps());
    }

    @GetMapping("/musclegroup/traps")
    public ResponseEntity<?> getTrapsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.traps());
    }

    @GetMapping("/musclegroup/triceps")
    public ResponseEntity<?> getTricepsWorkout() {
        return ResponseEntity.ok(exerciseMuscleGroupService.triceps());
    }

    /**
     * Exercise difficulty
     */
    @GetMapping("/difficulty/beginner")
    public ResponseEntity<?> getBeginnerWorkout(){
        return ResponseEntity.ok(exerciseDifficultyService.beginner());
    }

    @GetMapping("/difficulty/intermediate")
    public ResponseEntity<?> getIntermediateWorkout(){
        return ResponseEntity.ok(exerciseDifficultyService.intermediate());
    }
    
    @GetMapping("/difficulty/expert")
    public ResponseEntity<?> getExpertWorkout(){
        return ResponseEntity.ok(exerciseDifficultyService.expert());
    }


}
