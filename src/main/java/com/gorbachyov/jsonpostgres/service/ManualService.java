package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Engine;
import com.gorbachyov.jsonpostgres.entities.Manual;
import com.gorbachyov.jsonpostgres.repositories.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManualService {
    @Autowired
    private ManualRepository manualRepository;

    public Manual updateMaunual(Long id, Manual manual) {

        if (manualRepository.findById(id).isPresent()) {
            Manual existingManual = manualRepository.findById(id).get();

            existingManual.setManualType(manual.getManualType());


            Manual updatedManual = manualRepository.save(existingManual);

            return new Manual(updatedManual.getId(), updatedManual.getManualType());
        } else {
            throw new RuntimeException("manual doesn't exist");
        }
    }

    public void deleteManual(Long id) {
        if (manualRepository.findById(id).isPresent()) {
            manualRepository.deleteById(id);
        } else {
            throw new RuntimeException("manual doesn't exist");
        }
    }
}
