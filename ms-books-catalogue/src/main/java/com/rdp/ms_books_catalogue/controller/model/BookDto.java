package com.rdp.ms_books_catalogue.controller.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookDto {
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
