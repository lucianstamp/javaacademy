package com.javaacademy.learning.dto;

import com.javaacademy.learning.entities.User;

public class UserMapper {
    public static UserDTO book2BookDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());
        return userDTO;
    }
    public static User bookDto2Book(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        return user;
    }

}
