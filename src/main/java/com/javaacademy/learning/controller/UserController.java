package com.javaacademy.learning.controller;

import com.javaacademy.learning.entities.User;
import com.javaacademy.learning.service.UserService;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//operatii de tipul CRUD - Create read update delete
@RestController
@RequestMapping("/users")
public class UserController {
    //dependency injection + inversion of control
    //bean - un object manage-uit de SpringBoot.
    @Autowired
    private UserService userService;

    //cand cream date folosim POST
    //nu mai este nevoie de "/create" pentru ca POST reprezinta automat crearea unei noi entitati (ca principiu)
    @PostMapping()
    private ResponseEntity<?> create(@RequestBody User user) {
        // daca am avea parametrul ca DTO
        //pas1: il convertest intr-o unitate User (printr-o clasa Mapper)
        //pas2: linia de mai jos
        User createdUser = userService.create(user);
        //pas3: convertest entitatea din nou intr-un DTO
        return ResponseEntity.ok(createdUser);

    }

    //returnam un user dupaid
    //id-ul il pun in path/cale, pentru ca un GET nu are body
    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable long userId) {
        User foundUser = userService.getById(userId);
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping("/allusers")
    public ResponseEntity<?> findAll(){
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}
