package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Car;
import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineService {
    @Autowired
    private EngineRepository engineRepository;

    public Engine updateEngine(Long id, Engine engine) {

        if (engineRepository.findById(id).isPresent()) {
            Engine existingEngine = engineRepository.findById(id).get();

            existingEngine.setEngineType(engine.getEngineType());


            Engine updatedEngine = engineRepository.save(existingEngine);

            return new Engine(updatedEngine.getId(), updatedEngine.getEngineType());
        } else {
            throw new RuntimeException("engine doesn't exist");
        }
    }

    public void deleteEngine(Long id) {
        if (engineRepository.findById(id).isPresent()) {
            engineRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("engine doesn't exist");
        }
    }
}
