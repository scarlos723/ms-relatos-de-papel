package com.rdp.ms_books_payments.controller;

import com.rdp.ms_books_payments.controller.model.PaymentRequest;
import com.rdp.ms_books_payments.data.model.Payment;
import com.rdp.ms_books_payments.service.PaymentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Payments controller", description = "Microservicio encargado de registrar compras")
public class PaymentController {
    private final PaymentsService service;
    @PostMapping("/payments")
    public String CreatePayment(@RequestBody PaymentRequest request) {
        log.info("Received payment request: {}", request);
        String paymentId = service.createPayments(request);
        log.info("Payment created with ID: {}", paymentId);
        return paymentId;
    }

    @GetMapping("/payments")
    public List<Payment> GetPayments() {
        log.info("Fetching all payments");
        return service.getPayments();
    }
}
