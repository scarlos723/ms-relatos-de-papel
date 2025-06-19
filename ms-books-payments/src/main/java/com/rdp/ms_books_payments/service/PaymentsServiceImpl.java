package com.rdp.ms_books_payments.service;

import com.rdp.ms_books_payments.controller.model.PaymentRequest;
import com.rdp.ms_books_payments.data.PaymentJpaRepository;
import com.rdp.ms_books_payments.data.model.Payment;
import com.rdp.ms_books_payments.facade.BooksFacade;
import com.rdp.ms_books_payments.facade.model.Book;
import jakarta.transaction.Transactional;
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
    @Transactional
    public String createPayments(PaymentRequest payment) {

        List<Book> books = payment.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).toList();

        if (books.size() != payment.getBooks().size() || books.stream().anyMatch(book -> !book.getVisible())) {
            return "Algun libro no existe o no está disponible para la compra.";
        } else {
            Payment paymentEntity = Payment.builder()
                    .paymentId(payment.getPaymentId())
                    .userId(payment.getUserId())
                    .booksId(books.stream()
                            .map(Book::getId)
                            .collect(Collectors.toList()))
                    .price(payment.getPrice())
                    .paymentDate(payment.getPaymentDate())
                    .build();
            repository.save(paymentEntity);

            return "Pago creado exitosamente con Id: " + paymentEntity.getPaymentId();
        }

    }

    @Override
    @Transactional
    public List<Payment> getPayments() {

        List<Payment> payments = repository.findAll();
        if (payments.isEmpty()) {
            log.info("No payments found");
            return new ArrayList<>();
        } else {
            log.info("Found {} payments", payments.size());
            return payments;
        }
    }

}
