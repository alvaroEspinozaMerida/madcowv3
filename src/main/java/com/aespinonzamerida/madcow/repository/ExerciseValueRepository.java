package com.aespinonzamerida.madcow.repository;

import com.aespinonzamerida.madcow.entity.ExerciseValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseValueRepository extends JpaRepository<ExerciseValue, Long> {
    // Add any custom query methods here if needed
}
