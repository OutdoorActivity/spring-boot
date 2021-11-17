package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Car;
import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public CarService() {

    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Object show(Long id) {
        return id == null ? carRepository.findAll() : carRepository.findById(id);
    }


    public List<Car> createList(List<Car> cars) {
        return (List<Car>) carRepository.saveAll(cars);
    }

    public void updateCar(Long id, String manufarcturerName, String modelName, int year, Engine engine) {
        Car newCar = carRepository.findCarById(id);
        newCar.setManufacturerName(manufarcturerName);
        newCar.setModelName(modelName);
        newCar.setYear(year);
        newCar.setEngine(engine);
        carRepository.save(newCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }


}
