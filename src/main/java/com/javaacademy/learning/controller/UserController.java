package com.javaacademy.learning.controller;

import com.javaacademy.learning.service.UserService;
import com.javaacademy.learning.dto.UserDTO;
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
    private ResponseEntity<?> create(@RequestBody UserDTO user) {
        // daca am avea parametrul ca DTO
        //pas1: il convertest intr-o unitate User (printr-o clasa Mapper)
        //pas2: linia de mai jos
        UserDTO createdUser = userService.create(user);
        //pas3: convertest entitatea din nou intr-un DTO
        return ResponseEntity.ok(createdUser);

    }

    //returnam un user dupaid
    //id-ul il pun in path/cale, pentru ca un GET nu are body
    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable long userId) {
        UserDTO foundUser = userService.getById(userId);
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> update(@PathVariable long userId, @RequestBody UserDTO user) {

        UserDTO updatedUser = userService.update(userId,user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> delete(@PathVariable long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/{userId}/books/{bookId}")
    public void removeBookFromUser(@PathVariable long userId, @PathVariable long bookId) {
        userService.removeBookFromUser(userId,bookId);
    }



}
