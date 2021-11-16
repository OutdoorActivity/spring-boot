package com.gorbachyov.jsonpostgres.repositories;


import com.gorbachyov.jsonpostgres.entities.Gear;
import org.springframework.data.repository.CrudRepository;

public interface GearRepository extends CrudRepository<Gear, Long> {
}
