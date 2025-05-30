package com.rdp.ms_books_catalogue.data.model;

import com.rdp.ms_books_catalogue.controller.model.BookDto;
import com.rdp.ms_books_catalogue.data.utils.Consts;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    @Column(name = Consts.NAME, unique = true)
    private String name;

    @Column(name = Consts.PRICE , precision = 10 ,  scale = 2)
    private BigDecimal price;

    @Column(name = Consts.DESCRIPTION)
    private String description;

    @Column(name = Consts.VISIBLE)
    private Boolean visible;

    public void update(BookDto productDto) {
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.description = productDto.getDescription();
        this.visible = productDto.getVisible();
    }
}
