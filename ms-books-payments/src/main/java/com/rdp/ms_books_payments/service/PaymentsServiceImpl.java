package com.rdp.ms_books_payments.service;

import com.rdp.ms_books_payments.controller.model.PaymentRequest;
import com.rdp.ms_books_payments.data.PaymentJpaRepository;
import com.rdp.ms_books_payments.data.model.Payment;
import com.rdp.ms_books_payments.facade.BooksFacade;
import com.rdp.ms_books_payments.facade.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentsServiceImpl implements PaymentsService {

    private final BooksFacade booksFacade;
    private final PaymentJpaRepository repository;

    @Override
    public String createPayment(PaymentRequest payment) {

        List<Book> books = payment.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).toList();
        BigDecimal totalPrice = books.stream()
                .map(Book::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (books.size() != payment.getBooks().size() || books.stream().anyMatch(book -> !book.getVisible())) {
            return null;
        } else {
            Payment paymentEntity = Payment.builder()
                    .paymentId(payment.getPaymentId())
                    .userId(payment.getUserId())
                    .booksId(books.stream()
                            .map(Book::getId)
                            .collect(Collectors.toList()))
                    .price(totalPrice)
                    .paymentDate(payment.getPaymentDate())
                    .build();
            repository.save(paymentEntity);

            return "Payment created successfully with ID: " + paymentEntity.getPaymentId();
        }

    }

    @Override
    public List<Payment> getPayments() {
        return new ArrayList<>();
    }

}
