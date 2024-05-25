package com.taller2.carservice.service;

import com.taller2.carservice.dto.CarDto;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<CarDto> getAllCarsAvailable();
    CarDto reserveCar(UUID id);
    CarDto returnCar(UUID id);
}
