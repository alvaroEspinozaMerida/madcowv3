package com.aespinonzamerida.madcow.repository;

import com.aespinonzamerida.madcow.entity.ExerciseValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseValuesRepository extends JpaRepository<ExerciseValues, Long> {
    // Add any custom query methods here if needed
}
