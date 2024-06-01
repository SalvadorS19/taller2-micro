package com.taller2.carservice.service;

import com.taller2.carservice.dto.CarDto;
import com.taller2.carservice.dto.CarToSaveDto;

import java.util.List;
import java.util.UUID;

public interface CarService {

    CarDto create(CarToSaveDto car);
    CarDto findById(UUID id);
    List<CarDto> findAll();
    void delete(UUID id);
    List<CarDto> getAllAvailableCars();
    CarDto reserveCar(UUID id);
    CarDto returnCar(UUID id);
}
