package com.taller2.bookingservice.service;

import com.taller2.bookingservice.dto.BookingDto;
import com.taller2.bookingservice.dto.BookingMapper;
import com.taller2.bookingservice.dto.BookingToSaveDto;
import com.taller2.bookingservice.entity.Booking;
import com.taller2.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingMapper bookingMapper, BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper= bookingMapper;
    }

    @Override
    public BookingDto crearBooking (BookingToSaveDto bookingToSaveDto) {
        Booking booking = this.bookingMapper.bookingTosaveDtoToBooking(bookingToSaveDto);
        booking= bookingRepository.save(booking);
        return this.bookingMapper.bookingToBookingDto(booking);
    }

    @Override
    public BookingDto buscarBookingById(UUID id) {
        Booking booking = this.bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Booking no existe"));
        return this.bookingMapper.bookingToBookingDto(booking);
    }
}


