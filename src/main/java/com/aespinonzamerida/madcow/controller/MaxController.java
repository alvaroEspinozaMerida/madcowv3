package com.aespinonzamerida.madcow.controller;

import com.aespinonzamerida.madcow.entity.Max;
import com.aespinonzamerida.madcow.request.MaxUpdateRequest;
import com.aespinonzamerida.madcow.service.MaxJPADataAccessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/max")
public class MaxController {

    private final MaxJPADataAccessService maxJPADataAccessService;

    public MaxController(MaxJPADataAccessService maxJPADataAccessService) {
        this.maxJPADataAccessService = maxJPADataAccessService;
    }

    @GetMapping("/getMaxByName/{userId}/{workoutName}")
    public Max getMaxByName(@PathVariable("userId") long userId, @PathVariable("workoutName") String workoutName){
        return this.maxJPADataAccessService.getMaxByWorkoutNameAndUser(userId, workoutName);
    }


//    @PutMapping("/{userId}/update/{workoutName}")
//    public void updateCustomer(@PathVariable("userId") long userId, @PathVariable("workoutName") String workoutName, @RequestBody MaxUpdateRequest maxUpdateRequest) {
//       this.maxJPADataAccessService.updateMaxByIdAndWorkoutName(userId,workoutName,maxUpdateRequest);
//    }

    @PostMapping("/{userId}/update/{workoutName}")
    public void updateMaxByIdAndWorkoutName(@PathVariable("userId") long userId, @PathVariable("workoutName") String workoutName, @RequestBody MaxUpdateRequest maxUpdateRequest) {
        this.maxJPADataAccessService.updateMaxByIdAndWorkoutName(userId,workoutName,maxUpdateRequest);
    }



    @GetMapping("/{userId}/ORM/{workoutName}")
    public double getORM(@PathVariable("userId") long userId, @PathVariable("workoutName") String workoutName){
        return this.maxJPADataAccessService.getORM(userId,workoutName);
    }

    @GetMapping("/{userId}/FRM/{workoutName}")
    public double getFRM(@PathVariable("userId") long userId, @PathVariable("workoutName") String workoutName){
        return this.maxJPADataAccessService.getFRM(userId,workoutName);
    }


}
