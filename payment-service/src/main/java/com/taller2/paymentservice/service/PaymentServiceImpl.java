package com.taller2.paymentservice.service;

import com.taller2.paymentservice.dto.PaymentDto;
import com.taller2.paymentservice.dto.PaymentMapper;
import com.taller2.paymentservice.entity.Payment;
import com.taller2.paymentservice.dto.PaymentToSaveDto;
import com.taller2.paymentservice.entity.PaymentStatus;
import com.taller2.paymentservice.repository.PaymentRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public PaymentDto processPayment(PaymentToSaveDto payment) {
        Payment paymentSave = Payment.builder()
                .bookingId(payment.bookingId())
                .creditCard(payment.creditCard())
                .amount(payment.amount())
                .status(PaymentStatus.COMPLETED)
                .transactionId(UUID.randomUUID())
                .build();
        paymentSave = paymentRepository.save(paymentSave);
        return paymentMapper.paymentToPaymentDTO(paymentSave);
    }

    @Override
    public PaymentDto findByPaymentId(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Error buscando pago"));
        return paymentMapper.paymentToPaymentDTO(payment);
    }

    @Override
    public List<PaymentDto> findAllPayments() {
        return paymentMapper.paymentsToPaymentDTOs(paymentRepository.findAll());
    }

    @Override
    public void deletePayment(UUID id) {
        paymentRepository.deleteById(id);
    }
}
