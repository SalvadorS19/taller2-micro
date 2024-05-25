package com.taller2.bookingservice.repository;

import com.taller2.bookingservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

}
