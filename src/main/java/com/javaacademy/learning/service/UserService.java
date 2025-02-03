package com.javaacademy.learning.service;


import com.javaacademy.learning.entities.User;
import com.javaacademy.learning.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//clasa de business logic (un serviciu pe care aplicatia il ofera)
@Service
//@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {

        return userRepository.save(user);
    }

    public User getById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        return user;

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
