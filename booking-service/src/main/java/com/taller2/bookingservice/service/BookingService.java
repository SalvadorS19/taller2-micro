package com.taller2.bookingservice.service;

import com.taller2.bookingservice.repository.BookingRepository;

public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}
