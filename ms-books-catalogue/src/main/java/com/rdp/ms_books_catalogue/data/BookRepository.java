package com.rdp.ms_books_catalogue.data;

import com.rdp.ms_books_catalogue.data.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final BookJpaRepository repository;
    public List<Book> getBooks() {
        return repository.findAll();
    }
}
