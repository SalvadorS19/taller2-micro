package com.taller2.paymentservice.service;

import com.taller2.paymentservice.dto.PaymentMapper;
import com.taller2.paymentservice.entity.Payment;
import com.taller2.paymentservice.dto.PaymentCreateDTO;
import com.taller2.paymentservice.dto.PaymentDTO;
import com.taller2.paymentservice.entity.PaymentStatus;
import com.taller2.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentDTO processPayment(PaymentCreateDTO paymentCreateDTO) {
        Payment payment = Payment.builder()
                .bookingId(paymentCreateDTO.bookingId())
                .creditCard(paymentCreateDTO.creditCard())
                .amount(paymentCreateDTO.amount())
                .status(PaymentStatus.COMPLETED)
                .transactionId(UUID.randomUUID())
                .build();
        return paymentMapper.paymentToPaymentDTO(payment);
    }

    @Override
    public PaymentDTO getPaymentById(UUID id) {
        Payment payment =  paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error buscando pago"));
        return paymentMapper.paymentToPaymentDTO(payment);
    }
}
