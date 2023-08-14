package com.aespinonzamerida.madcow.repository;

import com.aespinonzamerida.madcow.entity.User;
import com.aespinonzamerida.madcow.entity.ExerciseValues;
import com.aespinonzamerida.madcow.entity.Workout;
import com.aespinonzamerida.madcow.request.WorkoutUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
//    List<Workout> findByUserAndDay(User user, Day day);

//    Optional<Workout> findByUserIdAndWorkoutType(long id, char workoutType);

//    void generateWorkoutByUserId(long id, WorkoutUpdateRequest workoutUpdateRequest);
//    void updateWorkoutByUserId(long id, WorkoutUpdateRequest workoutUpdateRequest);
//
//    List<ExerciseValues> getExercise1(User user, char workoutType);


//    @Query("SELECT ev.exValues FROM Workout w JOIN w.exercise1 ev " +
//            "WHERE w.user.id = :userId AND w.workoutType = :workoutType")
//    List<List<Double>>  findExercise1ByUserAndDay(@Param("userId") Long userId, @Param("workoutType") char workoutType);

}