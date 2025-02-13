package com.javaacademy.learning.controller;

import com.javaacademy.learning.dto.BookDTO;
import com.javaacademy.learning.dto.BookMapper;
import com.javaacademy.learning.entities.Book;
import com.javaacademy.learning.service.BookService;
import com.javaacademy.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @PostMapping("/{userId}")
    public ResponseEntity<BookDTO> create(@PathVariable Long userId, @RequestBody BookDTO bookDTO) {
        Book bookToCreate = BookMapper.bookDTO2Book(bookDTO);
        Book createdBook = bookService.create(bookToCreate, userId);
        return ResponseEntity.ok(BookMapper.book2BookDTO(createdBook));
    }

}
