package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.entities.SteeringWheel;
import com.gorbachyov.jsonpostgres.repositories.SteeringWheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SteeringWheelService {
    @Autowired
    private SteeringWheelRepository steeringWheelRepository;

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
        if (steeringWheelRepository.findById(id).isPresent()) {
            steeringWheelRepository.deleteById(id);
        } else {
            throw new RuntimeException("steering wheel doesn't exist");
        }
    }

}

