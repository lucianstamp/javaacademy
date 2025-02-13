package com.javaacademy.learning.service;

import com.javaacademy.learning.dto.BookDTO;
import com.javaacademy.learning.dto.BookMapper;
import com.javaacademy.learning.entities.Book;
import com.javaacademy.learning.entities.User;
import com.javaacademy.learning.repository.BookRepository;
import com.javaacademy.learning.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    //creare user cu book
    public Book create(Book bookToCreate, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        user.addBook(bookToCreate);
        bookRepository.save(bookToCreate);
        return bookToCreate;
    }

    public BookDTO createWithoutUser(BookDTO bookDTO) {
        Book book = BookMapper.bookDTO2Book(bookDTO);
        Book savedBook = bookRepository.save(book);
        BookDTO savedBookDTO = BookMapper.book2BookDTO(savedBook);
        return savedBookDTO;
    }

    public List<Book> getAllBooks(Long userId) {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
    }

    public List<Book> getBooksByUserId(Long userId) {
        return bookRepository.findByUserId(userId);
    }
    @Transactional
    public void addExistingBookToUser(Long bookId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User with ID " + userId + " not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new RuntimeException("Book with ID " + bookId + " not found"));

        book.setUser(user);
        user.addBook(book);

        bookRepository.save(book);
    }
    @Transactional
    public void deleteUserAndBooks(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        userRepository.delete(user);
    }


    public BookDTO createBookWithUser(Long userId, BookDTO bookDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        Book book = BookMapper.bookDTO2Book(bookDTO);
        user.addBook(book);
        bookRepository.save(book);
        return BookMapper.book2BookDTO(book);




    }





}
