package com.aespinonzamerida.madcow.controller;


import com.aespinonzamerida.madcow.exception.ResourceNotFoundException;
import com.aespinonzamerida.madcow.entity.User;
import com.aespinonzamerida.madcow.dto.UserDTO;
import com.aespinonzamerida.madcow.service.UserJPADataAccessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/madcow/users/")
public class UserController {

    private final UserJPADataAccessService userJPADataAccessService;

    public UserController(UserJPADataAccessService userJPADataAccessService) {
        this.userJPADataAccessService = userJPADataAccessService;
    }


    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userJPADataAccessService.getAllUsers();
    }

    @PostMapping ("/add")
    String createUser(@RequestBody UserDTO userDTO){
        userJPADataAccessService.createUser(userDTO);
        return "New User was added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userJPADataAccessService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
        return ResponseEntity.ok(user);
    }
//
//    @PutMapping("/users/calculate_maxes/{email}")
//    public ResponseEntity<User> calculateMaxesByEmail(@PathVariable String email){
//        User user = userService.findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
//
//        User updatedUser = userService.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }


//    @GetMapping("/usersEmail/{email}")
//    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
//        User user = userService.findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that EMAIL does not exist"));
//        return ResponseEntity.ok(user);
//    }
//
//    @PutMapping("/users/calculate_maxes/{email}")
//    public ResponseEntity<User> calculateMaxesByEmail(@PathVariable String email){
//        User user = userService.findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that ID does not exist"));
////        user.calculateMaxes();
//
//        User updatedUser = userService.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @PutMapping("/users/create_workouts/{email}")
//    public ResponseEntity<User> createWorkoutsByEmail(@PathVariable String email){
//        User user = userService.findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("User with that email does not exist"));
////        user.addWorkouts();
////        user.createWorkouts();
//        User updatedUser = userService.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }



}
