package com.taller2.paymentservice.service;

import com.taller2.paymentservice.dto.PaymentCreateDTO;
import com.taller2.paymentservice.dto.PaymentDTO;
import com.taller2.paymentservice.entity.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentDTO findByPaymentId(UUID paymentId);
    List<PaymentDTO> findAllPayments();
    Payment processPayment(PaymentCreateDTO paymentCreateDTO);
    void deletePayment(UUID paymentId);
}
