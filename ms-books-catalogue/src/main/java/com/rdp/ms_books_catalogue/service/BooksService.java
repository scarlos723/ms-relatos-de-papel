package com.rdp.ms_books_catalogue.service;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.model.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BooksService {
    List<Book> getBooks(String title,
                        String author,
                        String category,
                        String isbn,
                        LocalDate publicationDate,
                        Integer rating,
                        BigDecimal price,
                        String description, Boolean visible);
    Book getBook(String id);
    Book createBook(BookDto book);
    Book updateBook(Long id, BookDto book);
    Book patchBook(Long id, Map<String, Object> updates);
    String deleteBook(Long id);
}
