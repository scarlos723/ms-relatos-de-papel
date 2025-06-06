package com.rdp.ms_books_catalogue.data.model;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.utils.Consts;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Consts.TITLE, unique = true)
    private String title;

    @Column(name = Consts.AUTHOR)
    private String author;

    @Column(name = Consts.CATEGORY)
    private String category;

    @Column(name = Consts.ISBN)
    private String isbn;

    @Column(name = Consts.PUBLICATION_DATE)
    private LocalDate publicationDate;

    @Column(name = Consts.RATING)
    private Integer rating;

    @Column(name = Consts.PRICE , precision = 10 ,  scale = 2)
    private BigDecimal price;

    @Column(name = Consts.DESCRIPTION)
    private String description;

    @Column(name = Consts.VISIBLE)
    private Boolean visible;

    public void update(BookDto productDto) {
        this.title = productDto.getTitle();
        this.author = productDto.getAuthor();
        this.category = productDto.getCategory();
        this.isbn = productDto.getIsbn();
        this.publicationDate = productDto.getPublicationDate();
        this.rating = productDto.getRating();
        this.price = productDto.getPrice();
        this.description = productDto.getDescription();
        this.visible = productDto.getVisible();
    }
}
