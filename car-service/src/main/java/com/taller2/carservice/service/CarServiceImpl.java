package com.taller2.carservice.service;

import com.taller2.carservice.entity.Car;
import com.taller2.carservice.repository.CarRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
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

    public Car reserveCar(UUID id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("El carro no existe"));
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
