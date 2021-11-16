package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.Gear;
import com.gorbachyov.jsonpostgres.repositories.GearRepository;
import com.gorbachyov.jsonpostgres.service.GearService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "gear/api")
@AllArgsConstructor
public class GearController {

    private GearService gearService;
    private GearRepository gearRepository;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return id == null ? gearRepository.findAll() : gearRepository.findById(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Gear create(@RequestBody Gear message) {
        return gearRepository.save(message);
    }

    @PostMapping(value = "create/several")
    public List<Gear> create(@RequestBody List<Gear> message) {
        return (List<Gear>) gearRepository.saveAll(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id, @PathVariable("id") Gear gearFromDb,
                       @RequestBody Gear gear) {
        gearService.updateGear(id, gear);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        gearService.deleteGear(id);
    }
}
