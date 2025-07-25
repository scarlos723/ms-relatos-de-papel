package com.rdp.ms_books_catalogue.controller;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.model.Book;
import com.rdp.ms_books_catalogue.service.BooksService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Books controller", description = "Microservicio encargado del catálogo de la aplicación")
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

    @GetMapping
    ("/books/{id}")
    public ResponseEntity<Book> getBook (@PathVariable String id) {
        log.info("Fetching book with id: {}", id);
        Book book = service.getBook(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            log.warn("Book with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @Validated @RequestBody BookDto request) {
        log.info("Updating book {}: {}", id, request);
        try {
            Book updatedBook = service.updateBook(id, request);
            return ResponseEntity.ok(updatedBook);
        } catch (IllegalArgumentException e) {
            log.error("Error updating book: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<Book> patchBook(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        log.info("Patching book {}: {}", id, updates);
        try {
            Book patchedBook = service.patchBook(id, updates);
            return ResponseEntity.ok(patchedBook);
        } catch (IllegalArgumentException e) {
            log.error("Error patching book: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        log.info("Deleting book with id: {}", id);
        try {
            String result = service.deleteBook(id);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            log.error("Error deleting book: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}