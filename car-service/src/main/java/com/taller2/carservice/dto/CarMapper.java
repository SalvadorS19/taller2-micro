package com.taller2.carservice.dto;

import com.taller2.carservice.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto carToBookingDto(Car car);
    Car carToSaveDtoToCar(CarToSaveDto carToSaveDto);
}
