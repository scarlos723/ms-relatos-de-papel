package com.rdp.ms_books_payments.service;

import com.rdp.ms_books_payments.controller.model.PaymentRequest;
import com.rdp.ms_books_payments.data.model.Payment;

import java.util.List;

public interface PaymentsService {
    String createPayment(PaymentRequest payment);
    List<Payment> getPayments();
}
