package com.taller2.bookingservice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID carId;
    private UUID customerId;
    private BookingStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
