package com.aespinonzamerida.madcow.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import com.aespinonzamerida.madcow.model.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "_users")
@Data
@NoArgsConstructor

@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Max> maxes ;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Workout>workouts;

    private String email;

    private double[] weights;
    private int[] reps ;

    public User(String email, double[]weights, int[]reps){
        this.email = email;
        this.weights = weights;
        this.reps = reps;
        this.maxes = new ArrayList<>();
        this.workouts = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            maxes.add(new Max(Constants.WORKOUT_NAMES[i], this.weights[i],this.reps[i],this));
        }

        this.workouts.add(new Workout(this.maxes.get(0), this.maxes.get(1), this.maxes.get(2), 'A',this));
    }

    public void addWorkout(Workout newWorkout){
        this.workouts.add(newWorkout);
    }




}
