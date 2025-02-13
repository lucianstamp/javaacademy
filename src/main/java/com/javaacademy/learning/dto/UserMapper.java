package com.javaacademy.learning.dto;

import com.javaacademy.learning.entities.Application;
import com.javaacademy.learning.entities.User;

import java.util.List;
import java.util.ArrayList;

public class UserMapper {
    public static UserDTO user2UserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());

        // Mapăm books
        if (user.getBooks() != null) {
            userDTO.setBooks(user.getBooks().stream()
                    .map(BookMapper::book2BookDTO)
                    .toList());
        } else {
            userDTO.setBooks(new ArrayList<>()); // Evităm null
        }

        // Mapăm applications
        if (user.getApplications() != null) {
            userDTO.setApplications(user.getApplications().stream()
                    .map(ApplicationMapper::application2ApplicationDTO)
                    .toList());
        } else {
            userDTO.setApplications(new ArrayList<>());
        }

        return userDTO;
    }

    public static User userDTO2User(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());

        // Mapăm books
        if (userDTO.getBooks() != null) {
            user.setBooks(userDTO.getBooks().stream()
                    .map(BookMapper::bookDTO2Book)
                    .toList());
        } else {
            user.setBooks(new ArrayList<>());
        }

        // Mapăm applications
        if (userDTO.getApplications() != null) {
            user.setApplications(userDTO.getApplications().stream()
                    .map(ApplicationMapper::applicationDTO2Application)
                    .toList());
        } else {
            user.setApplications(new ArrayList<>());
        }

        return user;
    }
}
