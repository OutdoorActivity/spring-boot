package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Car;
import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {
    @Autowired
    private EngineRepository engineRepository;

    public Engine create(Engine engine) {
        return engineRepository.save(engine);
    }



    public Object show(Long id) {
        return id == null ? engineRepository.findAll() : engineRepository.findById(id);
    }

    public List<Engine> createList(List<Engine> engines) {
        return (List<Engine>) engineRepository.saveAll(engines);
    }

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
        engineRepository.deleteById(id);
    }
}
