package com.taller2.carservice.service;

import com.taller2.carservice.entity.Car;
import com.taller2.carservice.repository.CarRepository;
import org.hibernate.service.spi.ServiceException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }

    public List<Car> getAllAvailableCars() {
        return carRepository.findByAvailableTrue();
    }

    public Car reserveCar() {
        Car car = carRepository.findByAvailableTrue().get(0);
        car.setAvailable(false);
        carRepository.save(car);
        return car;
    }

    public Car returnCar(UUID id) {
        Car car = carRepository.findById(id).orElseThrow(()-> new ServiceException("No se encontro vehiculo"));
        car.setAvailable(true);
        carRepository.save(car);
        return car;
    }
}
