package com.rdp.ms_books_catalogue.controller;

import com.rdp.ms_books_catalogue.data.model.Book;
import com.rdp.ms_books_catalogue.service.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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

            @RequestParam(required = false) String name,

            @RequestParam(required = false) BigDecimal price,

            @RequestParam(required = false) String description,

            @RequestParam(required = false) Boolean visible
    ){
        log.info("headers: {}", headers);
        List<Book> products = service.getBooks(name, price, description, visible);

        if (products != null) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
}
