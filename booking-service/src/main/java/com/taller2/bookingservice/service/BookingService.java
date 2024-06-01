package com.taller2.bookingservice.service;

import com.taller2.bookingservice.dto.BookingDto;
import com.taller2.bookingservice.dto.BookingToSaveDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingDto create (BookingToSaveDto bookingToSaveDto);
    BookingDto findById(UUID id);
    List<BookingDto> findAll();
    void deleteById(UUID id);
}
