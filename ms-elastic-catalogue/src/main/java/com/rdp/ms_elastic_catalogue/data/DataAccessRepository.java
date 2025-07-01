package com.rdp.ms_elastic_catalogue.data;

import com.rdp.ms_elastic_catalogue.controller.model.AggregationDetails;
import com.rdp.ms_elastic_catalogue.controller.model.BooksQueryResponse;
import com.rdp.ms_elastic_catalogue.data.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.range.ParsedRange;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DataAccessRepository {

    @Value("${server.fullAddress}")
    private String serverFullAddress;

    private final BookRepository bookRepository;
    private final ElasticsearchOperations elasticsearchOperations;

    private final String[] descriptionSearchFields = {"description", "description._2gram", "description._3gram"};
    private final String[] titleSearchFields = {"title", "title._2gram", "title._3gram"};

    @SneakyThrows
    public BooksQueryResponse findBooks(
            String title,
            String author,
            String category,
            String isbn,
            String publicationDate,
            String rating,
            String price,
            String description
    ) {
        BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

        if (!StringUtils.isEmpty(title)) {
            querySpec.must(QueryBuilders.multiMatchQuery(title, titleSearchFields));
        }
        if (!StringUtils.isEmpty(author)) {
            querySpec.must(QueryBuilders.matchQuery("author", author));
        }
        if (!StringUtils.isEmpty(category)) {
            querySpec.must(QueryBuilders.termQuery("category", category));
        }
        if (!StringUtils.isEmpty(isbn)) {
            querySpec.must(QueryBuilders.matchQuery("isbn", isbn));
        }
        if (publicationDate != null) {
            querySpec.must(QueryBuilders.matchQuery("publicationDate", publicationDate));
        }
        if (!StringUtils.isEmpty(rating)) {
            if (rating.contains("-")) {
                String[] parts = rating.split("-");
                double from = Double.parseDouble(parts[0]);
                double to = Double.parseDouble(parts[1]);
                querySpec.must(QueryBuilders.rangeQuery("rating").from(from).to(to));
            } else {
                double ratingVal = Double.parseDouble(rating);
                querySpec.must(QueryBuilders.termQuery("rating", ratingVal));
            }
        }
        if (!StringUtils.isEmpty(price)) {
            if (price.contains("-")) {
                String[] parts = price.split("-");
                double from = Double.parseDouble(parts[0]);
                double to = Double.parseDouble(parts[1]);
                querySpec.must(QueryBuilders.rangeQuery("price").from(from).to(to));
            } else {
                double priceVal = Double.parseDouble(price);
                querySpec.must(QueryBuilders.termQuery("price", priceVal));
            }
        }
        if (!StringUtils.isEmpty(description)) {
            querySpec.must(QueryBuilders.multiMatchQuery(description, descriptionSearchFields));
        }
        if (!querySpec.hasClauses()) {
            querySpec.must(QueryBuilders.matchAllQuery());
        }

        querySpec.must(QueryBuilders.termQuery("visible", true));

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

        //Agregaciones
        queryBuilder.addAggregation(AggregationBuilders.terms(
                "categories_agg"
        ).field("category"
        ).size(1000));
        //rating

        queryBuilder.addAggregation(AggregationBuilders.range(
                "rating_agg"
        ).field("rating")
                .addRange(0, 1)
                .addRange(1, 2)
                .addRange(2, 3)
                .addRange(3, 4)
                .addRange(4, 5));

        //price
        queryBuilder.addAggregation(AggregationBuilders.range(
                "price_agg"
        ).field("price").addRange(0, 10).addRange(10, 20).addRange(20, 30).addRange(30, 40).addRange(40, 50));



        Query query = queryBuilder.build();
        SearchHits<Book> searchHits = elasticsearchOperations.search(query, Book.class);

        return new BooksQueryResponse(searchHits.getSearchHits().stream().map(SearchHit::getContent).toList(),
                getResponseAggregations(searchHits));
    }

    private Map<String, List<AggregationDetails>> getResponseAggregations(SearchHits<Book> result) {
        Map<String, List<AggregationDetails>> aggregations = new HashMap<>();

        if (result.hasAggregations()) {
            Map<String, Aggregation> aggs = result.getAggregations().asMap();

            aggs.forEach((key, value) -> {

                //Si no existe la clave en el mapa, la creamos
                if (!aggregations.containsKey(key)) {
                    aggregations.put(key, new LinkedList<>());
                }

                //Si la agregacion es de tipo termino, recorremos los buckets
                if (value instanceof ParsedStringTerms parsedStringTerms) {
                    parsedStringTerms.getBuckets().forEach(bucket -> {
                        aggregations.get(key).add(new AggregationDetails(bucket.getKey().toString(), (int) bucket.getDocCount()));
                    });
                }

                //Si la agregacion es de tipo rango, recorremos tambien los buckets
                if (value instanceof ParsedRange parsedRange) {
                    parsedRange.getBuckets().forEach(bucket -> {
                        aggregations.get(key).add(new AggregationDetails(bucket.getKeyAsString(), (int) bucket.getDocCount()));
                    });
                }
            });
        }
        return aggregations;
    }

}
