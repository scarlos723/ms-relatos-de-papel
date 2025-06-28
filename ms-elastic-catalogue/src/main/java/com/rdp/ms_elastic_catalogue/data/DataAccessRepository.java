package com.rdp.ms_elastic_catalogue.data;

import com.rdp.ms_elastic_catalogue.controller.model.BooksQueryResponse;
import com.rdp.ms_elastic_catalogue.data.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DataAccessRepository {

    @Value("${server.fullAddress}")
    private String serverFullAddress;

    private final BookRepository bookRepository;
    private final ElasticsearchOperations elasticsearchOperations;

    private final String[] descriptionSearchFields = {"description", "description._2gram", "description._3gram"};

    @SneakyThrows
    public BooksQueryResponse findBooks(
            String title,
            String author,
            String category,
            String isbn,
            java.time.LocalDate publicationDate,
            String rating,
            java.math.BigDecimal price,
            String description
    ) {
        BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

        if(!StringUtils.isEmpty(title)) {
            querySpec.must(QueryBuilders.matchQuery("title", title));
        }
        if(!StringUtils.isEmpty(author)) {
            querySpec.must(QueryBuilders.matchQuery("author", author));
        }
        if(!StringUtils.isEmpty(category)) {
            querySpec.must(QueryBuilders.termQuery("category", category));
        }
        if(!StringUtils.isEmpty(isbn)) {
            querySpec.must(QueryBuilders.matchQuery("isbn", isbn));
        }
        if(publicationDate != null) {
            querySpec.must(QueryBuilders.matchQuery("publicationDate", publicationDate));
        }
        if(!StringUtils.isEmpty(rating)) {
            querySpec.must(QueryBuilders.termQuery("rating", rating));
        }
        if(price != null) {
            querySpec.must(QueryBuilders.termQuery("price", price));
        }
        if(!StringUtils.isEmpty(description)) {
            querySpec.must(QueryBuilders.multiMatchQuery(description, descriptionSearchFields));
        }
        if(!querySpec.hasClauses()){
            querySpec.must(QueryBuilders.matchAllQuery());
        }

        querySpec.must(QueryBuilders.termQuery("visible", true));

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

        Query query = queryBuilder.build();
        SearchHits<Book> searchHits = elasticsearchOperations.search(query, Book.class);

        return new BooksQueryResponse(searchHits.getSearchHits().stream().map(SearchHit::getContent).toList());
    }
}
