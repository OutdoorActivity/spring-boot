package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "engine/api", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class EngineController {
    @Autowired
    private EngineService engineService;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return engineService.show(id);
    }

    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Engine create(@RequestBody Engine engine) {
        return engineService.create(engine);
    }

    @PostMapping(value = "create/several", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Engine> create(@RequestBody List<Engine> engines) {
        return engineService.createList(engines);
    }

    @PutMapping(value = "update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody Engine engine) {
        engineService.updateEngine(id, engine);
    }

    @DeleteMapping(value = "delete/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
        engineService.deleteEngine(id);
    }
}
