package com.taller2.bookingservice.controller;

import com.taller2.bookingservice.service.BookingServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingServiceImpl bookingServiceImpl;

    public BookingController(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl = bookingServiceImpl;
    }

}
