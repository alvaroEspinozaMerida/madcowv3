package com.aespinonzamerida.madcow.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class ExerciseValues {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="workout_id")
    @JsonBackReference
    Workout workout;
    @OneToMany(mappedBy = "exerciseValues", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private List<ExerciseValue> values = new ArrayList<>();



    public ExerciseValues(Workout workout) {

        this.workout = workout;
    }

    public ExerciseValues() {

    }

    public void addValue(ExerciseValue newValue){

        values.add(newValue);
    }

    public void setValues( List<ExerciseValue> exValues) {
        this.values = exValues;
    }

    public  List<ExerciseValue> getValues() {
        return values;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
