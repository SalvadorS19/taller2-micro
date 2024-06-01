package com.taller2.paymentservice.dto;

import com.taller2.paymentservice.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO paymentToPaymentDTO(Payment payment);
    List<PaymentDTO> paymentsToPaymentDTOs(List<Payment> payments);
}
