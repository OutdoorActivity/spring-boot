package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.entities.Gear;
import com.gorbachyov.jsonpostgres.repositories.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearService {
    @Autowired
    private GearRepository gearRepository;

    public Gear create(Gear gear) {
        return gearRepository.save(gear);
    }

    public Object show(Long id) {
        return id == null ? gearRepository.findAll() : gearRepository.findById(id);
    }

    public List<Gear> createList(List<Gear> gears) {
        return (List<Gear>) gearRepository.saveAll(gears);
    }

    public Gear updateGear(Long id, Gear gear) {

        if (gearRepository.findById(id).isPresent()) {
            Gear existingGear = gearRepository.findById(id).get();

            existingGear.setGearType(gear.getGearType());


            Gear updatedGear = gearRepository.save(existingGear);

            return new Gear(updatedGear.getId(), updatedGear.getGearType());
        } else {
            throw new RuntimeException("gear doesn't exist");
        }
    }

    public void deleteGear(Long id) {
        gearRepository.deleteById(id);
    }
}
