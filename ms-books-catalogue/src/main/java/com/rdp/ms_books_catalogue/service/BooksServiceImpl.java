package com.rdp.ms_books_catalogue.service;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.BookRepository;
import com.rdp.ms_books_catalogue.data.model.Book;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Slf4j

public class BooksServiceImpl implements BooksService{
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getBooks(String title,
                                String author,
                               String category,
                               String isbn,
                               LocalDate publicationDate,
                               Integer rating,
                               BigDecimal price, String description, Boolean visible){
        if (StringUtils.hasLength(title) || price!=null || StringUtils.hasLength(description)
                || visible != null) {
            System.out.printf("title: %s, author: %s, category: %s, isbn: %s, publicationDate: %s, rating: %s, price: %.2f, description: %s, visible: %s%n",
                    title, author, category, isbn, publicationDate, rating, price, description, visible);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }


    @Transactional
    public Book createBook(BookDto request) {
        if (request == null || !StringUtils.hasText(request.getTitle())) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setCategory(request.getCategory());
        book.setIsbn(request.getIsbn());
        book.setPublicationDate(request.getPublicationDate());
        book.setRating(request.getRating());
        book.setPrice(request.getPrice());
        book.setDescription(request.getDescription());
        book.setVisible(request.getVisible() != null ? request.getVisible() : true);

        return repository.save(book);
    }
    @Transactional
    public Book updateBook(Long id, BookDto request) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con id: " + id));
        // Actualización total
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setCategory(request.getCategory());
        book.setIsbn(request.getIsbn());
        book.setPublicationDate(request.getPublicationDate());
        book.setRating(request.getRating());
        book.setPrice(request.getPrice());
        book.setDescription(request.getDescription());
        book.setVisible(request.getVisible() != null ? request.getVisible() : true);

        return repository.save(book);
    }

    @Transactional
    public Book patchBook(Long id, Map<String, Object> updates) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con id: " + id));
        // Actualización parcial solo de los campos presentes en updates
        if (updates.containsKey("title")) book.setTitle((String) updates.get("title"));
        if (updates.containsKey("author")) book.setAuthor((String) updates.get("author"));
        if (updates.containsKey("category")) book.setCategory((String) updates.get("category"));
        if (updates.containsKey("isbn")) book.setIsbn((String) updates.get("isbn"));
        if (updates.containsKey("publicationDate")) book.setPublicationDate(LocalDate.parse((String) updates.get("publicationDate")));
        if (updates.containsKey("rating")) book.setRating((Integer) updates.get("rating"));
        if (updates.containsKey("price")) book.setPrice(new BigDecimal(updates.get("price").toString()));
        if (updates.containsKey("description")) book.setDescription((String) updates.get("description"));
        if (updates.containsKey("visible")) book.setVisible((Boolean) updates.get("visible"));

        return repository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con id: " + id));
        repository.delete(book);
    }
}
