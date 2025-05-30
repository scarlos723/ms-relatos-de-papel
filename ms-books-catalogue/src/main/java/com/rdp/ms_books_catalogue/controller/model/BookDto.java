package com.rdp.ms_books_catalogue.controller.model;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookDto {
    private String name;
    private BigDecimal price;
    private String description;
    private Boolean visible;
}
