package com.taller2.carservice.dto;

import java.util.UUID;

public record CarDto(
        UUID id,
        String model,
        String maker,
        Boolean available
) {
}
