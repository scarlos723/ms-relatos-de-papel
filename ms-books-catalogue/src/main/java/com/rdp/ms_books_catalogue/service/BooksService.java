package com.rdp.ms_books_catalogue.service;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.model.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BooksService {
    List<Book> getBooks(String title,
                        String author,
                        String category,
                        String isbn,
                        LocalDate publicationDate,
                        Integer rating,
                        BigDecimal price,
                        String description, Boolean visible);
    Book createBook(BookDto book);
}
