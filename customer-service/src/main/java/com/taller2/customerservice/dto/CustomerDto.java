package com.taller2.customerservice.dto;

import java.util.UUID;

public record CustomerDto(
        UUID id,
        String fullName
) {
}
