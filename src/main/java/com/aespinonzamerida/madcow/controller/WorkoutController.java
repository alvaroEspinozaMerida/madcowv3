package com.aespinonzamerida.madcow.controller;

import com.aespinonzamerida.madcow.exception.ResourceNotFoundException;
import com.aespinonzamerida.madcow.entity.User;
import com.aespinonzamerida.madcow.entity.ExerciseValues;
import com.aespinonzamerida.madcow.request.MaxUpdateRequest;
import com.aespinonzamerida.madcow.request.WorkoutUpdateRequest;
import com.aespinonzamerida.madcow.service.UserJPADataAccessService;
import com.aespinonzamerida.madcow.service.WorkoutJPADataAccessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/workout")
public class WorkoutController {

    private final WorkoutJPADataAccessService workoutJPADataAccessService;
    private final UserJPADataAccessService userJPADataAccessService;


    public WorkoutController(WorkoutJPADataAccessService workoutJPADataAccessService, UserJPADataAccessService userJPADataAccessService) {
        this.workoutJPADataAccessService = workoutJPADataAccessService;
        this.userJPADataAccessService = userJPADataAccessService;
    }

    @GetMapping("/{userId}/exercise1/{workoutType}")
    public List<ExerciseValues> getExercise1(@PathVariable("userId") long userId, @PathVariable("workoutType") char workoutType){
        return this.workoutJPADataAccessService.getExercise1(userId, workoutType);

    }

    @PostMapping("/{userId}/update_exercise1/{workoutName}/{workoutType}")
    public String updateExercise1(@PathVariable("userId") long userId, @PathVariable("workoutType")
    char workoutType,@PathVariable("workoutName") String workoutName, @RequestBody MaxUpdateRequest maxUpdateRequest){
        this.workoutJPADataAccessService.updateWorkoutByIdAndWorkoutName(userId,workoutType,workoutName,maxUpdateRequest);
        return "Exercise1 Updated";
    }



}
