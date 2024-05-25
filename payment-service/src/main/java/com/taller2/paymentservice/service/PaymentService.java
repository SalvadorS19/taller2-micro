package com.taller2.paymentservice.service;

import com.taller2.paymentservice.dto.PaymentCreateDTO;
import com.taller2.paymentservice.dto.PaymentDTO;
import java.util.UUID;

public interface PaymentService {

    PaymentDTO processPayment(PaymentCreateDTO paymentCreateDTO);

    PaymentDTO getPaymentById(UUID id);
}
