package com.aespinonzamerida.madcow.entity;

import com.aespinonzamerida.madcow.entity.ExerciseValues;
import com.aespinonzamerida.madcow.model.Constants;
import com.aespinonzamerida.madcow.model.Day;
import com.aespinonzamerida.madcow.entity.Max;
import com.aespinonzamerida.madcow.entity.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Setter
public class Workout {
    @Id
    @GeneratedValue
    private long id;

    private char workoutType;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;
    private Day day;

    @OneToMany(mappedBy = "workout", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private List<ExerciseValues> exercise1 = new ArrayList<>();
//    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL)
//    private List<ExerciseValues> exercise2 = new ArrayList<>();
//    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL)
//    private List<ExerciseValues> exercise3 = new ArrayList<>();

    @Transient
    private Max maxEx1;
    @Transient
    private Max maxEx2;
    @Transient
    private Max maxEx3;

    public Workout(Max max1, Max max2, Max max3, char workoutType, User user){
        this.user = user;
        this.maxEx1 = max1;
        this.maxEx2 = max2;
        this.maxEx3 = max3;
        this.workoutType = workoutType;
//        this.exercise1 = calcNewExercise(this.maxEx1);

        this.setNewExercise();

    }


    public void setExercise1(List<ExerciseValues> exercise1) {
        this.exercise1 = exercise1;
    }


    public void setNewExercise(Max newMax, List<ExerciseValues> exercise){

        for(int i = 0; i < 12; i++){
            ExerciseValues weekSets = new ExerciseValues(this);

            for(int j = 0; j < 5; j++){
               weekSets.addValue(new ExerciseValue(weekSets,0));
            }

            exercise.add(weekSets);
        }

    }
















    public List<ExerciseValues> calcNewExercise(Max max){

        List<ExerciseValues> newExercise = new ArrayList<>();

        for(int i = 0; i < 12; i++){
            double dayMax;
            if(i == 0){
                dayMax = max.getStartWeight();
            }
            else {
                dayMax = Math.round((max.getStartWeight()*(Math.pow(1.025,i))/(2* Constants.PLATE))) *2*Constants.PLATE ;
            }
            ExerciseValues weekSets = new ExerciseValues(this);

            for(int j = 0; j < 5; j++){
                if(j == 0){
//                    weekSets.getExValues().add(new ExerciseValue(weekSets, dayMax));
                    weekSets.addValue(new ExerciseValue(weekSets, dayMax));
                }else {
                    //Math.round( dayMax*(1-Constants.SET_INTERVAL*(j))/(2*Constants.PLATE))*2*Constants.PLATE
//                    weekSets.getExValues().add(new ExerciseValue(weekSets, Math.round( dayMax*(1-Constants.SET_INTERVAL*(j))/(2*Constants.PLATE))*2*Constants.PLATE));
                    weekSets.addValue(new ExerciseValue(weekSets, Math.round( dayMax*(1-Constants.SET_INTERVAL*(j))/(2*Constants.PLATE))*2*Constants.PLATE));
                }
            }
            newExercise.add(weekSets);
        }

        return newExercise;
    }
}