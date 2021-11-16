package com.gorbachyov.jsonpostgres.repositories;

import com.gorbachyov.jsonpostgres.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

}
