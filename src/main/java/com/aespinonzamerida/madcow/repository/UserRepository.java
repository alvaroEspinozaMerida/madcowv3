package com.aespinonzamerida.madcow.repository;

import com.aespinonzamerida.madcow.dto.UserDTO;
import com.aespinonzamerida.madcow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    Optional<User> findById(long id);
    Optional<User> findByEmail(String email);


}