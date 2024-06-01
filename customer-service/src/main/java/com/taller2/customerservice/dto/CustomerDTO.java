package com.taller2.customerservice.dto;

import java.util.UUID;

public record CustomerDTO(
        UUID id,
        String fullName
) {
}
