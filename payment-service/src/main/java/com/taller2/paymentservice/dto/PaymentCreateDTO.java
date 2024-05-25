package com.taller2.paymentservice.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentCreateDTO(
        UUID bookingId,
        String creditCard,
        BigDecimal amount
) {
}
