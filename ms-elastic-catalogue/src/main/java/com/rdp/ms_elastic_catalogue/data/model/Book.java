package com.rdp.ms_elastic_catalogue.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "books", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Field(type = FieldType.Text, name = "author")
    private String author;

    @Field(type = FieldType.Keyword, name = "category")
    private String category;

    @Field(type = FieldType.Text, name = "isbn")
    private String isbn;

    @Field(type = FieldType.Date, name = "publicationDate")
    private String publicationDate; // Using String for date to avoid conversion issues in Elasticsearch

    @Field(type = FieldType.Integer, name = "rating")
    private Integer rating;

    @Field(type = FieldType.Double, name = "price")
    private Double price; // Using Double for price to match Elasticsearch's numeric type

    @Field(type = FieldType.Search_As_You_Type, name = "description")
    private String description;

    @Field(type = FieldType.Boolean, name = "visible")
    private Boolean visible;

}
