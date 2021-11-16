package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.repositories.EngineRepository;
import com.gorbachyov.jsonpostgres.service.EngineService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "engine/api")
@AllArgsConstructor
public class EngineController {

    private EngineService engineService;
    private EngineRepository engineRepository;



    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return id == null ? engineRepository.findAll() : engineRepository.findById(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Engine create(@RequestBody Engine message) {
        return engineRepository.save(message);
    }

    @PostMapping(value = "create/several")
    public List<Engine> create(@RequestBody List<Engine> message) {
        return (List<Engine>) engineRepository.saveAll(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody Engine engine) {
        engineService.updateEngine(id, engine);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        engineService.deleteEngine(id);
    }
}
