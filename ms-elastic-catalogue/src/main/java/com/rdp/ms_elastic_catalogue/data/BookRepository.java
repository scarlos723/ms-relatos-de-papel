package com.rdp.ms_elastic_catalogue.data;

import com.rdp.ms_elastic_catalogue.data.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findAll();
}
