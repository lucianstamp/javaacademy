package com.javaacademy.learning.service;


import com.javaacademy.learning.entities.User;
import com.javaacademy.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create(User user) {

    }
}
