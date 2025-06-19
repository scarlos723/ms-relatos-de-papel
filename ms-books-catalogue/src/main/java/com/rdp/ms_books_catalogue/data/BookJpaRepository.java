package com.rdp.ms_books_catalogue.data;

import com.rdp.ms_books_catalogue.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

interface BookJpaRepository  extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);
    List<Book> findByIsbn(String isbn);
    List<Book> findByPublicationDate(java.time.LocalDate publicationDate);
    List<Book> findByRating(Integer rating);
    List<Book> findByPrice(java.math.BigDecimal price);
    List<Book> findByDescription(String description);
    List<Book> findByVisible(Boolean visible);
}
