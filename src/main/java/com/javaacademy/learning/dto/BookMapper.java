package com.javaacademy.learning.dto;

import com.javaacademy.learning.entities.Book;

public class BookMapper {
    public static BookDTO book2BookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(bookDTO.getName());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }

    public static Book bookDTO2Book(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }

}
