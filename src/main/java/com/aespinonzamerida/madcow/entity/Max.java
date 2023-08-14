package com.aespinonzamerida.madcow.entity;
import com.aespinonzamerida.madcow.model.Constants;
import com.aespinonzamerida.madcow.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Entity
@AllArgsConstructor
@Data
public class Max {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public String workoutName;
    public double weight;
    public double reps;

    public Max(){}

    public Max(User user) {
        this.user = user;
    }

    public Max(String workoutName, double weight, double reps, User user) {
        this.workoutName = workoutName;
        this.weight = weight;
        this.reps = reps;
        this.user = user;
    }
    public double getOneRepMax(){
        return Math.round(weight/(1.0278 - (.0278*reps)));
    }

    public double getFiveRepMax(){
        return Math.round(getOneRepMax() * (1.0278 - (.0278*5)));
    }

    public double getStartWeight(){
        return Math.round(getFiveRepMax() * Math.pow((1/1.025),(Constants.PRWEEK-1))/(2*Constants.PLATE)) * 2 * Constants.PLATE;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Max max = (Max) o;
        return Double.compare(max.weight, weight) == 0 && Double.compare(max.reps, reps) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, reps);
    }
}
