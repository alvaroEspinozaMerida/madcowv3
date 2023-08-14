package com.aespinonzamerida.madcow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity

public class ExerciseValue {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "exercise_values_id")
    @JsonBackReference
    private ExerciseValues exerciseValues;

    private double value;

    public ExerciseValue(ExerciseValues exerciseValues, double value) {
        this.exerciseValues = exerciseValues;
        this.value = value;
    }

    public ExerciseValue() {

    }

    public ExerciseValues getExerciseValues() {
        return exerciseValues;
    }

    public void setExerciseValues(ExerciseValues exerciseValues) {
        this.exerciseValues = exerciseValues;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    // ... other fields, getters, setters, constructors, etc.
}
