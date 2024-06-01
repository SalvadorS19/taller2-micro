package com.taller2.carservice.dto;

import com.taller2.carservice.entity.BookingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDto(
        UUID id,
        UUID carId,
        UUID customerId,
        BookingStatus status,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
