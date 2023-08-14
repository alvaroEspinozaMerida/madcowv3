package com.aespinonzamerida.madcow.repository;

import com.aespinonzamerida.madcow.entity.Max;
import com.aespinonzamerida.madcow.request.MaxUpdateRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaxRepository extends JpaRepository<Max, Long> {

//    List<Max> getAllMaxes(long userId);
//    void updateMaxByIdAndWorkoutName(long userId, String workoutName, MaxUpdateRequest maxUpdateRequest);
//    boolean deleteMaxByIdAndWorkoutName(long userId, String workoutName);
//    Max getMaxByWorkoutNameAndUser(long userId, String workoutName);
//
//    double getORM (long userId, String workoutName);
//    double getFRM(long userId, String workoutName);


}
