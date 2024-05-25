package com.taller2.paymentservice.dto;

import com.taller2.paymentservice.entity.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDTO(
        UUID id,
        UUID bookingId,
        String creditCard,
        BigDecimal amount,
        PaymentStatus status,
        UUID transactionId
) {
}
