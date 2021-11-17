package com.gorbachyov.jsonpostgres.controllers;


import com.gorbachyov.jsonpostgres.entities.Car;
import com.gorbachyov.jsonpostgres.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "car/api", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)

public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return carService.show(id);
    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @PostMapping(value = "create/several", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> create(@RequestBody List<Car> cars) {
        return carService.createList(cars);
    }

    @PostMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody Car car) {
        carService.updateCar(id, car.getManufacturerName(), car.getModelName(), car.getYear(), car.getEngine());
    }

    @DeleteMapping(value = "delete/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
        carService.deleteCar(id);
    }


}