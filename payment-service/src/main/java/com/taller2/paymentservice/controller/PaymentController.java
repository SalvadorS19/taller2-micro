package com.taller2.paymentservice.controller;

import com.taller2.paymentservice.dto.PaymentToSaveDto;
import com.taller2.paymentservice.dto.PaymentDto;
import com.taller2.paymentservice.service.PaymentService;
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
    public PaymentDto processPayment(@RequestBody PaymentToSaveDto paymentToSaveDto) {
        return paymentService.processPayment(paymentToSaveDto);
    }

    @GetMapping("/{id}")
    public PaymentDto findByPaymentId(@PathVariable UUID id) {
        return paymentService.findByPaymentId(id);
    }

    @GetMapping
    public List<PaymentDto> findAllPayments() {
        return paymentService.findAllPayments();
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable UUID id) {
        paymentService.deletePayment(id);
    }
}
