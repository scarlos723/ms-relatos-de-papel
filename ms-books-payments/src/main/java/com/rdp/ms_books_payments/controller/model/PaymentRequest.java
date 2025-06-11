package com.rdp.ms_books_payments.controller.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaymentRequest {
    private Long paymentId;
    private Long userId;
    private BigDecimal price;
    private java.time.LocalDate paymentDate;
    private List<String> books;
}
