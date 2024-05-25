package com.taller2.carservice.controller;

import com.taller2.carservice.entity.Car;
import com.taller2.carservice.service.CarServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarServiceImpl carServiceImpl;

    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    public Car createCar(Car car) {
        return carServiceImpl.createCar(car);
    }

    public List<Car> availableCars() {
        return carServiceImpl.getAllAvailableCars();
    }

    public Car reserveCar(UUID id) {
        return carServiceImpl.reserveCar(id);
    }

    public Car returnCar(UUID id) {
        return carServiceImpl.returnCar(id);
    }
}
