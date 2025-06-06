package com.rdp.ms_books_catalogue.data;

import com.rdp.ms_books_catalogue.data.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final BookJpaRepository repository;
    public List<Book> getBooks() {
        return repository.findAll();
    }
    public Book save(Book book) {
        return repository.save(book);
    }
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }
    public void delete(Book book) {
    repository.delete(book);
}
}
