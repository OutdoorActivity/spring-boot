package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.Gear;
import com.gorbachyov.jsonpostgres.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "gear/api", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class GearController {
    @Autowired
    private GearService gearService;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return gearService.show(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Gear create(@RequestBody Gear message) {
        return gearService.create(message);
    }

    @PostMapping(value = "create/several")
    public List<Gear> create(@RequestBody List<Gear> message) {
        return gearService.createList(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody Gear gear) {
        gearService.updateGear(id, gear);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        gearService.deleteGear(id);
    }
}
