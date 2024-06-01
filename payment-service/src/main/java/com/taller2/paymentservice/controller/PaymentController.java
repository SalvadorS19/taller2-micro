package com.taller2.paymentservice.controller;

import com.taller2.paymentservice.dto.PaymentCreateDTO;
import com.taller2.paymentservice.dto.PaymentDTO;
import com.taller2.paymentservice.entity.Payment;
import com.taller2.paymentservice.entity.PaymentStatus;
import com.taller2.paymentservice.service.PaymentService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment processPayment(@RequestBody PaymentCreateDTO paymentCreateDTO) {
        return paymentService.processPayment(paymentCreateDTO);
    }

    @GetMapping("/{id}")
    public PaymentDTO findByPaymentId(@PathVariable UUID id) {
        return paymentService.findByPaymentId(id);
    }

    @GetMapping
    public List<PaymentDTO> findAllPayments() {
        return paymentService.findAllPayments();
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable UUID id) {
        paymentService.deletePayment(id);
    }
}
