package com.taller2.bookingservice.service;

import com.taller2.bookingservice.controller.CarConsumer;
import com.taller2.bookingservice.dto.BookingDto;
import com.taller2.bookingservice.dto.BookingMapper;
import com.taller2.bookingservice.dto.BookingToSaveDto;
import com.taller2.bookingservice.entity.Booking;
import com.taller2.bookingservice.entity.BookingStatus;
import com.taller2.bookingservice.repository.BookingRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final CarConsumer carConsumer;

    public BookingServiceImpl(BookingMapper bookingMapper, BookingRepository bookingRepository, CarConsumer carConsumer) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper= bookingMapper;
        this.carConsumer = carConsumer;
    }

    @Override
    public BookingDto create(BookingToSaveDto booking) {
        Booking bookingToSave = Booking.builder()
                .carId(booking.carId())
                .customerId(booking.customerId())
                .startDate(LocalDateTime.now())
                .endDate(booking.endDate())
                .status(BookingStatus.CONFIRMED)
                .build();
        bookingToSave = bookingRepository.save(bookingToSave);
        carConsumer.reserveCar(booking.carId());
        return bookingMapper.bookingToBookingDto(bookingToSave);
    }

    @Override
    public BookingDto findById(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()-> new ServiceException("No se encontro la reserva"));
        return bookingMapper.bookingToBookingDto(booking);
    }

    @Override
    public List<BookingDto> findAll() {
        return bookingMapper.bookingListToBookingDtoList(bookingRepository.findAll());
    }

    @Override
    public void deleteById(UUID id) {
        bookingRepository.deleteById(id);
    }
}


