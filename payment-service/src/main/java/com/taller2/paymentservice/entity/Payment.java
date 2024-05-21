package com.taller2.paymentservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID bookingId;
    private String creditCard;
    private BigDecimal amount;
    private PaymentStatus status;
    private UUID transactionId;
}
