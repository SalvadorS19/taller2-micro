package com.taller2.paymentservice.dto;

import com.taller2.paymentservice.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDto paymentToPaymentDTO(Payment payment);
    List<PaymentDto> paymentsToPaymentDTOs(List<Payment> payments);
}
