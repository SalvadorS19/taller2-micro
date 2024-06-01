package com.taller2.paymentservice.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentToSaveDto(
        UUID bookingId,
        String creditCard,
        BigDecimal amount
) {
}
