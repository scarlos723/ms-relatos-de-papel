package com.rdp.ms_books_payments.facade;

import com.rdp.ms_books_payments.facade.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class BooksFacade {

    @Value("${getBook.url}")
    private String getBookUrl;

    private final WebClient.Builder webClient;

    public Book getBook(String id) {
        try {
            String url = String.format(getBookUrl, id);
            return webClient.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();
        } catch (Exception e) {
            log.error("Error retrieving book with ID {}: {}", id, e.getMessage());
            return null;
        }
    }
}
