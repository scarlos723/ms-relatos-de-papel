package com.rdp.ms_books_catalogue.service;

import com.rdp.ms_books_catalogue.data.BookRepository;
import com.rdp.ms_books_catalogue.data.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j

public class BooksServiceImpl implements BooksService{
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getBooks(String name, BigDecimal price, String description, Boolean visible){
        if (StringUtils.hasLength(name) || price!=null || StringUtils.hasLength(description)
                || visible != null) {
            System.out.printf("name: %s, price: %s, description: %s, visible: %s%n",
                    name, price, description, visible);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }
}
