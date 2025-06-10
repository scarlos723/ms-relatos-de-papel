package com.rdp.ms_books_payments.facade.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    private Long id;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private LocalDate publicationDate;
    private Integer rating;
    private BigDecimal price;
    private String description;
    private Boolean visible;
}
