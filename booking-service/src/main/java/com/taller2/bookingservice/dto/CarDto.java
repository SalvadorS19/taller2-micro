package com.taller2.bookingservice.dto;

import java.util.UUID;

public record CarDto(
        UUID id,
        String model,
        String maker,
        Boolean available
) {
}
