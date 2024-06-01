package com.taller2.carservice.controller;

import com.taller2.carservice.dto.BookingDto;
import com.taller2.carservice.entity.BookingStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "booking-service", url = "http://localhost:8081")
public interface BookingConsumer {
    @PutMapping("/booking/updateStatus")
    BookingDto updateStatus(@RequestParam UUID id, @RequestParam BookingStatus status);
    @GetMapping("/booking/byCar/{id}")
    BookingDto findByCarId(@PathVariable UUID id);
}
