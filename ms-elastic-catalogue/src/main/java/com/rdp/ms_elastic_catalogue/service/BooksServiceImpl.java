package com.rdp.ms_elastic_catalogue.service;

import com.rdp.ms_elastic_catalogue.controller.model.BooksQueryResponse;
import com.rdp.ms_elastic_catalogue.data.DataAccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final DataAccessRepository repository;

    @Override
    public BooksQueryResponse getBooks(
            String title,
            String author,
            String category,
            String isbn,
            java.time.LocalDate publicationDate,
            String rating,
            java.math.BigDecimal price,
            String description
    ) {
        return repository.findBooks(title, author, category, isbn, publicationDate, rating, price, description);
    }
}
