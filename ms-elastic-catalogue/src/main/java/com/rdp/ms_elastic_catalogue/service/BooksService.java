package com.rdp.ms_elastic_catalogue.service;

import com.rdp.ms_elastic_catalogue.controller.model.BooksQueryResponse;

public interface BooksService {

    BooksQueryResponse getBooks(
            String title,
            String author,
            String Category,
            String isbn,
            java.time.LocalDate publicationDate,
            String rating,
            java.math.BigDecimal price,
            String description
    );
}
