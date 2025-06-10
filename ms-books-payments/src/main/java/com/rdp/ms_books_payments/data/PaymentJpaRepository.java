package com.rdp.ms_books_payments.data;

import com.rdp.ms_books_payments.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
