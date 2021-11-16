package com.gorbachyov.jsonpostgres.repositories;


import com.gorbachyov.jsonpostgres.entities.Engine;
import org.springframework.data.repository.CrudRepository;

public interface EngineRepository extends CrudRepository<Engine, Long> {
}
