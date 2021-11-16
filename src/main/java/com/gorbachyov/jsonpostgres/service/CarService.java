package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Car;
import com.gorbachyov.jsonpostgres.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car updateCar(Long id, Car car) {

        if (carRepository.findById(id).isPresent()) {
            Car existingCar = carRepository.findById(id).get();

            existingCar.setManufacturerName(car.getManufacturerName());
            existingCar.setModelName(car.getModelName());
            existingCar.setYear(car.getYear());


            Car updatedVehicle = carRepository.save(existingCar);

            return new Car(updatedVehicle.getId(), updatedVehicle.getManufacturerName(),
                    updatedVehicle.getModelName(), updatedVehicle.getYear());
        } else {
            throw new RuntimeException("car doesn't exist");
        }
    }

    public void deleteCar(Long id) {
        if (carRepository.findById(id).isPresent()) {
            carRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("car doesn't exist");
        }
    }

}
