package com.taller2.bookingservice.dto;

import com.taller2.bookingservice.entity.BookingStatus;

import java.time.LocalDateTime;

public record BookingToSaveDto(
        BookingStatus status,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
