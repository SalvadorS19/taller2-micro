package com.taller2.paymentservice.service;

import com.taller2.paymentservice.dto.PaymentToSaveDto;
import com.taller2.paymentservice.dto.PaymentDto;
import com.taller2.paymentservice.entity.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentDto findByPaymentId(UUID paymentId);
    List<PaymentDto> findAllPayments();
    PaymentDto processPayment(PaymentToSaveDto paymentToSaveDto);
    void deletePayment(UUID paymentId);
}
