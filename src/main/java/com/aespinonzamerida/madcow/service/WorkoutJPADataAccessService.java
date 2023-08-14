package com.aespinonzamerida.madcow.service;

import com.aespinonzamerida.madcow.entity.*;
import com.aespinonzamerida.madcow.repository.MaxRepository;
import com.aespinonzamerida.madcow.repository.UserRepository;
import com.aespinonzamerida.madcow.request.MaxUpdateRequest;
import com.aespinonzamerida.madcow.request.WorkoutUpdateRequest;
import com.aespinonzamerida.madcow.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutJPADataAccessService{

    private final WorkoutRepository workoutRepository;

    private final UserRepository userRepository;

    private final MaxRepository maxRepository;




    public WorkoutJPADataAccessService(WorkoutRepository workoutRepository, UserRepository userRepository, MaxRepository maxRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
        this.maxRepository = maxRepository;
    }

    public void generateWorkoutByUserId(long id, WorkoutUpdateRequest workoutUpdateRequest) {


    }


    public void updateWorkoutByUserId(long id, WorkoutUpdateRequest workoutUpdateRequest) {



    }


    public List<ExerciseValues> getExercise1(long userId, char workoutType) {

        Optional<User> userOptional = this.userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Do something with the user
            Workout workout = user.getWorkouts().stream()
                    .filter(m-> workoutType == m.getWorkoutType())
                    .findFirst()
                    .orElse(null);

            return workout.getExercise1();


        } else {

        }
        return null;
    }

    @Transactional
    public void updateWorkoutByIdAndWorkoutName(long userId, char workoutType, String workoutName,  MaxUpdateRequest maxUpdateRequest) {

        Optional<User> userOptional = this.userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            Workout workout = user.getWorkouts().stream()
                    .filter(m -> workoutType == m.getWorkoutType())
                    .findFirst()
                    .orElseThrow(null);

            Max max = user.getMaxes().stream()
                    .filter(m-> workoutName.equals(m.getWorkoutName()))
                    .findFirst()
                    .orElse(null);



            if(maxUpdateRequest.weight() != max.weight ){
                max.setWeight(maxUpdateRequest.weight());
                if(workoutName.equals("SQUAT")){
                    user.getWeights()[0] = max.getWeight();
                }
            }
            if(maxUpdateRequest.reps() != max.reps ){
                max.setReps(maxUpdateRequest.reps());
                if(workoutName.equals("SQUAT")){
                    user.getReps()[0] = (int) max.getReps();
                }
            }
            // Detach existing ExerciseValues entities from the current workout
            for (ExerciseValues exerciseValues : workout.getExercise1()) {

                for (ExerciseValue exerciseValue : exerciseValues.getValues()) {
                    exerciseValue.setExerciseValues(null);
                }
                exerciseValues.setValues(null);
            }
//            workout.setExercise1(null);
//
//            // Save the updated workout
//            workoutRepository.save(workout);
//
////            // Create new ExerciseValues entities and associate them with the workout
//            List<ExerciseValues> newExerciseValues = workout.calcNewExercise(max);
//
//
//            for (ExerciseValues exerciseValues : workout.getExercise1()) {
//
//                for (ExerciseValue exerciseValue : exerciseValues.getValues()) {
//                    exerciseValue.setExerciseValues();
//                }
//                exerciseValues.setValues(null);
//            }





            // Save the updated entities
            workoutRepository.save(workout);
            maxRepository.save(max);
            userRepository.save(user);



//            maxRepository.updateMax(max);
//            workoutRepository.updateWorkout(workout);
//            userRepository.updateUser(user);

//            workoutRepository.save(workout);
//            maxRepository.save(max);
//            userRepository.save(user);


        } else {

        }

    }










//    public List<ExerciseValues> getExercise1(User user, char workoutType) {
//
////        for(ExerciseValues e : this.workoutRepository.findByUserIdAAndWorkoutType(id,workoutType)){
////            for (Double f: e.getExValues()){
////                System.out.print(f +" ");
////            }
////            System.out.println();
////        }
//
//        return this.workoutRepository.findByUserAndWorkoutType(user,workoutType);
//    }


//    @Override
//    public List<ExerciseValues> getExercise1ByUserId(long id) {
//
//        List<ExerciseValues> exerciseValuesList = this.workoutRepository.findExercise1ByUserAndDay();
//        return null;
//    }
//
//    @Override
//    public List<ExerciseValues> getExercise2ByUserId(long id) {
//        return null;
//    }
//
//    @Override
//    public List<ExerciseValues> getExercise3ByUserId(long id) {
//        return null;
//    }
}
