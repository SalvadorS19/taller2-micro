package com.taller2.bookingservice.dto;

import com.taller2.bookingservice.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDto bookingToBookingDto(Booking booking);
    Booking bookingTosaveDtoToBooking(BookingToSaveDto bookingToSaveDto);
}
