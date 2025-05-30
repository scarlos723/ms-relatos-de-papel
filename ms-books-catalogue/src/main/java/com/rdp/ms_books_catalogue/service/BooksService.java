package com.rdp.ms_books_catalogue.service;

import com.rdp.ms_books_catalogue.data.model.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BooksService {
    List<Book> getBooks(String name, BigDecimal price, String description, Boolean visible);
}
