package com.taller2.bookingservice.service;

import com.taller2.bookingservice.dto.BookingDto;
import com.taller2.bookingservice.dto.BookingToSaveDto;
import com.taller2.bookingservice.entity.Booking;

import java.util.UUID;

public interface BookingService {

    BookingDto crearBooking (BookingToSaveDto bookingToSaveDto);
    BookingDto buscarBookingById(UUID id);
}
