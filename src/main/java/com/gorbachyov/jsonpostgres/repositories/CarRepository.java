package com.gorbachyov.jsonpostgres.repositories;

import com.gorbachyov.jsonpostgres.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
   Car findCarById(Long id);
}
