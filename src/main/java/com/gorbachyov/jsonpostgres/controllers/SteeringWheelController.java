package com.gorbachyov.jsonpostgres.controllers;

import com.gorbachyov.jsonpostgres.entities.SteeringWheel;
import com.gorbachyov.jsonpostgres.repositories.SteeringWheelRepository;
import com.gorbachyov.jsonpostgres.service.SteeringWheelService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "steeringWheel/api")
@AllArgsConstructor
public class SteeringWheelController {

    private SteeringWheelService steeringWheelService;
    private SteeringWheelRepository steeringWheelRepository;


    @GetMapping(value = "read", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object show(@RequestParam(required = false) Long id) {
        return id == null ? steeringWheelRepository.findAll() : steeringWheelRepository.findById(id);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SteeringWheel create(@RequestBody SteeringWheel message) {
        return steeringWheelRepository.save(message);
    }

    @PostMapping(value = "create/several")
    public List<SteeringWheel> create(@RequestBody List<SteeringWheel> message) {
        return (List<SteeringWheel>) steeringWheelRepository.saveAll(message);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") long id, @PathVariable("id") SteeringWheel steeringWheelFromDb,
                       @RequestBody SteeringWheel steeringWheel) {
        steeringWheelService.updateSteeringWheel(id, steeringWheel);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        steeringWheelService.deleteSteeringWheel(id);
    }
}
