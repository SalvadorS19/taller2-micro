package com.taller2.carservice.service;

import com.taller2.carservice.dto.CarDto;
import com.taller2.carservice.dto.CarMapper;
import com.taller2.carservice.dto.CarToSaveDto;
import com.taller2.carservice.entity.Car;
import com.taller2.carservice.repository.CarRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDto create(CarToSaveDto car) {
        Car carSave = Car.builder()
                .model(car.model())
                .maker(car.maker())
                .available(true)
                .build();
        carSave = carRepository.save(carSave);
        return carMapper.carToCarDto(carSave);
    }

    @Override
    public CarDto findbyId(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ServiceException("No se encontro vehiculo"));
        return carMapper.carToCarDto(car);
    }

    @Override
    public List<CarDto> findAll() {
        return carMapper.carsToCarDtos(carRepository.findAll());
    }

    @Override
    public void delete(UUID id) {
        carRepository.deleteById(id);
    }

    public List<CarDto> getAllAvailableCars() {
        return carMapper.carsToCarDtos(carRepository.findByAvailableTrue());
    }

    public CarDto reserveCar(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro vehiculo"));
        if (car.getAvailable()){
            car.setAvailable(false);
            car = carRepository.save(car);
            return carMapper.carToCarDto(car);
        } else {
            throw new RuntimeException("El carro no se encuentra disponible");
        }
    }

    public CarDto returnCar(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(()-> new ServiceException("No se encontro vehiculo"));
        if (!car.getAvailable()){
            car.setAvailable(true);
            car = carRepository.save(car);
            return carMapper.carToCarDto(car);
        } else {
            throw new RuntimeException("El carro no ha sido ocupado");
        }
    }
}
