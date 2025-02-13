package com.javaacademy.learning.service;
import com.javaacademy.learning.entities.Book;
import com.javaacademy.learning.entities.User;
import com.javaacademy.learning.repository.BookRepository;
import com.javaacademy.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public Book create(Book bookToCreate, Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
        user.addBook(bookToCreate);
        bookRepository.save(bookToCreate);
        return bookToCreate;
    }

}
