package com.taller2.paymentservice.dto;

import com.taller2.paymentservice.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO paymentToPaymentDTO(Payment payment);
}
