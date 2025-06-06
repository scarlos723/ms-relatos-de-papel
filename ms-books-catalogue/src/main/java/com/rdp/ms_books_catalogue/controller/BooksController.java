package com.rdp.ms_books_catalogue.controller;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.model.Book;
import com.rdp.ms_books_catalogue.service.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BooksController {
    private final BooksService service;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks (
            @RequestHeader Map<String, String> headers,

            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) LocalDate publicationDate,
            @RequestParam(required = false) Integer rating,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Boolean visible
    ){
        log.info("headers: {}", headers);
        List<Book> products = service.getBooks(title,  author, category, isbn, publicationDate, rating,
                price, description, visible);

        if (products != null) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@Validated @RequestBody BookDto request) {
        log.info("Creating new book: {}", request);
        try {
            Book createdBook = service.createBook(request);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            log.error("Error creating book: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
