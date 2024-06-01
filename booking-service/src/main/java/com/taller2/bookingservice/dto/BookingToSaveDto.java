package com.taller2.bookingservice.dto;

import com.taller2.bookingservice.entity.BookingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingToSaveDto(
        UUID carId,
        UUID customerId
) {
}
