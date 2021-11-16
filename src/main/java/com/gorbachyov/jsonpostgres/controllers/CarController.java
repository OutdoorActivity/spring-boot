package com.gorbachyov.jsonpostgres.controllers;


import com.gorbachyov.jsonpostgres.entities.Car;
import com.gorbachyov.jsonpostgres.repositories.CarRepository;
import com.gorbachyov.jsonpostgres.service.CarService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "car/api")
@AllArgsConstructor
public class CarController {


    private CarService carService;
    private CarRepository carRepository;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return id == null ? carRepository.findAll() : carRepository.findById(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car create(@RequestBody Car message) {
        return carRepository.save(message);
    }

    @PostMapping(value = "create/several")
    public List<Car> create(@RequestBody List<Car> message) {
        return (List<Car>) carRepository.saveAll(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody Car car) {
        carService.updateCar(id, car);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        carService.deleteCar(id);
    }


}