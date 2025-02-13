package com.javaacademy.learning.controller;

import com.javaacademy.learning.dto.BookDTO;
import com.javaacademy.learning.dto.BookMapper;
import com.javaacademy.learning.entities.Book;
import com.javaacademy.learning.service.BookService;
import com.javaacademy.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBookWithoutUser(@RequestBody BookDTO book) {
        BookDTO createdBook = bookService.createWithoutUser(book);
        return ResponseEntity.ok(createdBook);

    }

    @PostMapping("/{userId}")
    public ResponseEntity<BookDTO> create(@PathVariable Long userId, @RequestBody BookDTO bookDTO) {
        Book bookToCreate = BookMapper.bookDTO2Book(bookDTO);
        Book createdBook = bookService.create(bookToCreate, userId);
        return ResponseEntity.ok(BookMapper.book2BookDTO(createdBook));
    }
    @PutMapping("/{bookId}/users/{userId}")
    public void addExistingBookToUser(@PathVariable Long bookId, @PathVariable Long userId) {
        bookService.addExistingBookToUser(bookId, userId);

    }
    @PostMapping("/users/{usersId}")
    public BookDTO createBookWithUser(@PathVariable Long usersId, @RequestBody BookDTO bookDTO) {
        return bookService.createBookWithUser(usersId,bookDTO);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUserAndBooks(@PathVariable Long userId) {
        bookService.deleteUserAndBooks(userId);
    }
    @GetMapping("/users/{userId}")
    public List<Book> getBooksByUser(@PathVariable Long userId) {
        return bookService.getBooksByUserId(userId);
    }

}
