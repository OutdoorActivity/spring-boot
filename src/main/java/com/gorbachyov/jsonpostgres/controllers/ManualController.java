package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.Manual;
import com.gorbachyov.jsonpostgres.repositories.ManualRepository;
import com.gorbachyov.jsonpostgres.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "manual/api", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ManualController {
    @Autowired
    private ManualService manualService;

    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return manualService.show(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manual create(@RequestBody Manual message) {
        return manualService.create(message);
    }

    @PostMapping(value = "create/several")
    public List<Manual> create(@RequestBody List<Manual> message) {
        return manualService.createList(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody Manual manual) {
        manualService.updateManual(id, manual);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        manualService.deleteManual(id);
    }
}
