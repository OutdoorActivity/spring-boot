package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Manual;
import com.gorbachyov.jsonpostgres.entities.SteeringWheel;
import com.gorbachyov.jsonpostgres.repositories.SteeringWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteeringWheelService {
    @Autowired
    private SteeringWheelRepository steeringWheelRepository;

    public SteeringWheel create(SteeringWheel steeringWheel) {
        return steeringWheelRepository.save(steeringWheel);
    }

    public Object show(Long id) {
        return id == null ? steeringWheelRepository.findAll() : steeringWheelRepository.findById(id);
    }

    public List<SteeringWheel> createList(List<SteeringWheel> steeringWheels) {
        return (List<SteeringWheel>) steeringWheelRepository.saveAll(steeringWheels);
    }

    public SteeringWheel updateSteeringWheel(Long id, SteeringWheel steeringWheel) {

        if (steeringWheelRepository.findById(id).isPresent()) {
            SteeringWheel existingSteeringWheel = steeringWheelRepository.findById(id).get();

            existingSteeringWheel.setSteeringWheelType(steeringWheel.getSteeringWheelType());


            SteeringWheel updatedSteeringWheel = steeringWheelRepository.save(existingSteeringWheel);

            return new SteeringWheel(updatedSteeringWheel.getId(), updatedSteeringWheel.getSteeringWheelType());
        } else {
            throw new RuntimeException("steering wheel doesn't exist");
        }
    }

    public void deleteSteeringWheel(Long id) {
        steeringWheelRepository.deleteById(id);
    }

}

