package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.SteeringWheel;
import com.gorbachyov.jsonpostgres.service.SteeringWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "steeringWheel/api", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)

public class SteeringWheelController {
    @Autowired
    private SteeringWheelService steeringWheelService;

    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return steeringWheelService.show(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SteeringWheel create(@RequestBody SteeringWheel message) {
        return steeringWheelService.create(message);
    }

    @PostMapping(value = "create/several")
    public List<SteeringWheel> create(@RequestBody List<SteeringWheel> message) {
        return steeringWheelService.createList(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id,
                       @RequestBody SteeringWheel steeringWheel) {
        steeringWheelService.updateSteeringWheel(id, steeringWheel);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        steeringWheelService.deleteSteeringWheel(id);
    }
}
