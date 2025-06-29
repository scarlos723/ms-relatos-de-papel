package com.rdp.ms_elastic_catalogue.controller;

import com.rdp.ms_elastic_catalogue.controller.model.BooksQueryResponse;
import com.rdp.ms_elastic_catalogue.service.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<BooksQueryResponse> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String publicationDate,
            @RequestParam(required = false) String rating,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String description
    ) {
        log.info("Fetching books with filters: title={}, author={}, category={}, isbn={}, publicationDate={}, rating={}, price={}, description={}",
                title, author, category, isbn, publicationDate, rating, price, description);

        BooksQueryResponse response = booksService.getBooks(title, author, category, isbn, publicationDate, rating, price, description);
        return ResponseEntity.ok(response);
    }
}
