package com.taller2.carservice.controller;

import com.taller2.carservice.dto.CarDto;
import com.taller2.carservice.dto.CarToSaveDto;
import com.taller2.carservice.entity.Car;
import com.taller2.carservice.service.CarService;
import com.taller2.carservice.service.CarServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public CarDto create(@RequestBody CarToSaveDto car) {
        return carService.create(car);
    }

    @GetMapping("/{id}")
    public CarDto findbyId(@PathVariable UUID id) {
        return carService.findbyId(id);
    }

    @GetMapping
    public List<CarDto> findAll() {
        return carService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        carService.delete(id);
    }

    @GetMapping("/listAvailableCar")
    public List<CarDto> getAllAvailableCars() {
        return carService.getAllAvailableCars();
    }

    @PostMapping("/reserve/{id}")
    public CarDto reserveCar(@PathVariable UUID id) {
        return carService.reserveCar(id);
    }

    @PostMapping("/return/{id}")
    public CarDto returnCar(@PathVariable UUID id) {
        return carService.returnCar(id);
    }
}
