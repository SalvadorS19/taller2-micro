package com.taller2.carservice.controller;

import com.taller2.carservice.entity.Car;
import com.taller2.carservice.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public Car createCar(Car car) {
        return carService.createCar(car);
    }

    public List<Car> availableCars() {
        return carService.getAllAvailableCars();
    }

    public Car reserveCar() {
        return carService.reserveCar();
    }

    public Car returnCar(UUID id) {
        return carService.returnCar(id);
    }
}
