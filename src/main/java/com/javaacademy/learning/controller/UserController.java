package com.javaacademy.learning.controller;
import com.javaacademy.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //dependency injection + inversion of control
    //bean - un object manage-uit de SpringBoot.
    @Autowired
    private UserService userService;

    private ResponseEntity<?> create(){
        userService.create(user);
        return ResponseEntity.ok(null);

    }

}
