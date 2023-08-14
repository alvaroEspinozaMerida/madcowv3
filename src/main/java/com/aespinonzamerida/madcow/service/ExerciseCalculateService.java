package com.aespinonzamerida.madcow.service;

import com.aespinonzamerida.madcow.entity.Max;
import com.aespinonzamerida.madcow.model.Constants;

import java.util.ArrayList;
import java.util.List;

public class ExerciseCalculateService {

    public List<List<Double>> calcNewExercise(Max max) {
        List<List<Double>> newExercise = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            double dayMax;
            if (i == 0) {
                dayMax = max.getStartWeight();
            } else {
                dayMax = Math.round((max.getStartWeight() * (Math.pow(1.025, i)) / (2 * Constants.PLATE))) * 2 * Constants.PLATE;
            }

            List<Double> weekSets = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    weekSets.add(dayMax);
                } else {
                    weekSets.add(Math.round(dayMax * (1 - Constants.SET_INTERVAL * j) / (2 * Constants.PLATE)) * 2 * Constants.PLATE);
                }
            }

            newExercise.add(weekSets);
        }

        return newExercise;
    }

}
