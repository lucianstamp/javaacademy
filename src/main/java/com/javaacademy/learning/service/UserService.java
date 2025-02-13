package com.javaacademy.learning.service;


import com.javaacademy.learning.repository.UserRepository;
import com.javaacademy.learning.dto.UserDTO;
import com.javaacademy.learning.dto.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaacademy.learning.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//clasa de business logic (un serviciu pe care aplicatia il ofera)
@Service
//@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        User user = UserMapper.userDTO2User(userDTO);
        User savedUser = userRepository.save(user);
        UserDTO savedUserDTO = UserMapper.user2UserDTO(savedUser);
        return savedUserDTO;
    }

    public UserDTO getById(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.user2UserDTO(user);

    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::user2UserDTO).collect(Collectors.toList());
    }

    public UserDTO update(long userId, UserDTO user) {

        User existingUser = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAge(user.getAge());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.user2UserDTO(updatedUser);

    }
    public void removeBookFromUser(Long userId, Long bookId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        user.getBooks().removeIf(book -> book.getId().equals(bookId));
        userRepository.save(user);
    }

    public void delete(long userId) {
       userRepository.deleteById(userId);


    }


}
