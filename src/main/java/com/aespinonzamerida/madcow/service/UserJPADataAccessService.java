package com.aespinonzamerida.madcow.service;

import com.aespinonzamerida.madcow.entity.User;
import com.aespinonzamerida.madcow.dto.UserDTO;
import com.aespinonzamerida.madcow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJPADataAccessService {

    private final UserRepository userRepository;

    public UserJPADataAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void createUser(UserDTO userDTO) {

        User newUser = new User(userDTO.getEmail(), userDTO.getWeights(), userDTO.getReps());
        userRepository.save(newUser);
    }


    public User save(User user) {
        return null;
    }


    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return null;
    }
}
