package com.taller2.carservice.repository;

import com.taller2.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByAvailableTrue();
}
