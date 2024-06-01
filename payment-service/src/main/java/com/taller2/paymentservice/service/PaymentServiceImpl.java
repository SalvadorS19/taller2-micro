package com.taller2.paymentservice.service;

import com.taller2.paymentservice.dto.PaymentMapper;
import com.taller2.paymentservice.entity.Payment;
import com.taller2.paymentservice.dto.PaymentCreateDTO;
import com.taller2.paymentservice.dto.PaymentDTO;
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
    public Payment processPayment(PaymentCreateDTO payment) {
        Payment paymentToSave = Payment.builder()
                .bookingId(payment.bookingId())
                .creditCard(payment.creditCard())
                .amount(payment.amount())
                .status(PaymentStatus.COMPLETED)
                .transactionId(UUID.randomUUID())
                .build();
        paymentToSave = paymentRepository.save(paymentToSave);
        return paymentToSave;
    }

    @Override
    public PaymentDTO findByPaymentId(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Error buscando pago"));
        return paymentMapper.paymentToPaymentDTO(payment);
    }

    @Override
    public List<PaymentDTO> findAllPayments() {
        return paymentMapper.paymentsToPaymentDTOs(paymentRepository.findAll());
    }

    @Override
    public void deletePayment(UUID id) {
        paymentRepository.deleteById(id);
    }
}
