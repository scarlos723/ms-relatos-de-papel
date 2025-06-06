package com.rdp.ms_books_catalogue.service;

import com.rdp.ms_books_catalogue.data.BookRepository;
import com.rdp.ms_books_catalogue.data.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j

public class BooksServiceImpl implements BooksService{
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getBooks(String title,
                                String author,
                               String category,
                               String isbn,
                               LocalDate publicationDate,
                               Integer rating,
                               BigDecimal price, String description, Boolean visible){
        if (StringUtils.hasLength(title) || price!=null || StringUtils.hasLength(description)
                || visible != null) {
            System.out.printf("title: %s, author: %s, category: %s, isbn: %s, publicationDate: %s, rating: %s, price: %.2f, description: %s, visible: %s%n",
                    title, author, category, isbn, publicationDate, rating, price, description, visible);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }
}
