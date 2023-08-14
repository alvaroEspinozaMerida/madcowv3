package com.aespinonzamerida.madcow.service;

import com.aespinonzamerida.madcow.entity.User;
import com.aespinonzamerida.madcow.entity.Max;

import com.aespinonzamerida.madcow.repository.UserRepository;
import com.aespinonzamerida.madcow.request.MaxUpdateRequest;
import com.aespinonzamerida.madcow.repository.MaxRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaxJPADataAccessService{
    private final MaxRepository maxRepository;
    private final UserRepository userRepository;

    public MaxJPADataAccessService(MaxRepository maxRepository, UserRepository userRepository) {
        this.maxRepository = maxRepository;
//        this.userJPADataAccessService = userJPADataAccessService;
        this.userRepository = userRepository;
    }


    public List<Max> getAllMaxes(long id) {
        return null;
    }

    @Transactional
    public void updateMaxByIdAndWorkoutName(long userId, String workoutName, MaxUpdateRequest maxUpdateRequest) {

        Optional<User> userOptional = this.userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Do something with the user
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


        } else {

        }


    }


    public boolean deleteMaxByIdAndWorkoutName(long id, String workoutName) {
        return false;
    }

    public Max getMaxByWorkoutNameAndUser(long userId, String workoutName) {


        Optional<User> userOptional = this.userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Do something with the user
            Max max = user.getMaxes().stream()
                    .filter(m-> workoutName.equals(m.getWorkoutName()))
                    .findFirst()
                    .orElse(null);

            return max;

        } else {
            return null;
        }

    }



    public double getORM(long userId, String workoutName) {

        Optional<User> userOptional = this.userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Do something with the user
            Max max = user.getMaxes().stream()
                    .filter(m-> workoutName.equals(m.getWorkoutName()))
                    .findFirst()
                    .orElse(null);

            return max.getOneRepMax();

        } else {
            return -1;
        }

    }

    public double getFRM(long userId, String workoutName) {
        Optional<User> userOptional = this.userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Do something with the user
            Max max = user.getMaxes().stream()
                    .filter(m-> workoutName.equals(m.getWorkoutName()))
                    .findFirst()
                    .orElse(null);

            return max.getFiveRepMax();

        } else {
            return -1;
        }
    }
}
