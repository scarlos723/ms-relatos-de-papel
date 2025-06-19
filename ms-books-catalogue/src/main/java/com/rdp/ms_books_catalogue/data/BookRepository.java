package com.rdp.ms_books_catalogue.data;

import com.rdp.ms_books_catalogue.data.model.Book;
import com.rdp.ms_books_catalogue.data.utils.Consts;
import com.rdp.ms_books_catalogue.data.utils.SearchCriteria;
import com.rdp.ms_books_catalogue.data.utils.SearchOperation;
import com.rdp.ms_books_catalogue.data.utils.SearchStatement;
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
    public List<Book> search(
            String title,
            String author,
            String category,
            String isbn,
            java.time.LocalDate publicationDate,
            Integer rating,
            java.math.BigDecimal price,
            String description,
            Boolean visible
    ){
        SearchCriteria<Book> spec = new SearchCriteria<>();
       if(visible!=null){
           spec.add(new SearchStatement(Consts.VISIBLE, visible, SearchOperation.EQUAL));
        }
       if(title!=null){
           spec.add(new SearchStatement(Consts.TITLE, title, SearchOperation.LIKE));
       }
       if(author!=null){
           spec.add(new SearchStatement(Consts.AUTHOR, author, SearchOperation.LIKE));
       }
       if(category!=null){
           spec.add(new SearchStatement(Consts.CATEGORY, category, SearchOperation.MATCH));
       }
       if(isbn!=null){
           spec.add(new SearchStatement(Consts.ISBN, isbn, SearchOperation.MATCH));
       }
       if(publicationDate!=null){
           spec.add(new SearchStatement(Consts.PUBLICATION_DATE, publicationDate, SearchOperation.EQUAL));
       }
       if(rating!=null){
           spec.add(new SearchStatement(Consts.RATING, rating, SearchOperation.EQUAL));
       }
       if(price!=null){
           spec.add(new SearchStatement(Consts.PRICE, price, SearchOperation.EQUAL));
       }
       if(description!=null){
           spec.add(new SearchStatement(Consts.DESCRIPTION, description, SearchOperation.LIKE));
       }

       return repository.findAll(spec);
    }
}
