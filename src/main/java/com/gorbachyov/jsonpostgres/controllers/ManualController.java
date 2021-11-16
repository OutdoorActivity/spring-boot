package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.Manual;
import com.gorbachyov.jsonpostgres.repositories.ManualRepository;
import com.gorbachyov.jsonpostgres.service.ManualService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "manual/api")
@AllArgsConstructor
public class ManualController {

    private ManualService manualService;
    private ManualRepository manualRepository;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return id == null ? manualRepository.findAll() : manualRepository.findById(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manual create(@RequestBody Manual message) {
        return manualRepository.save(message);
    }

    @PostMapping(value = "create/several")
    public List<Manual> create(@RequestBody List<Manual> message) {
        return (List<Manual>) manualRepository.saveAll(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id, @PathVariable("id") Manual manualFromDb,
                       @RequestBody Manual manual) {
        manualService.updateMaunual(id, manual);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        manualService.deleteManual(id);
    }
}
