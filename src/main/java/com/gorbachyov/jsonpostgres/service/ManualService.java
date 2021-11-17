package com.gorbachyov.jsonpostgres.service;

import com.gorbachyov.jsonpostgres.entities.Gear;
import com.gorbachyov.jsonpostgres.entities.Manual;
import com.gorbachyov.jsonpostgres.repositories.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualService {
    @Autowired
    private ManualRepository manualRepository;

    public Manual create(Manual manual) {
        return manualRepository.save(manual);
    }

    public Object show(Long id) {
        return id == null ? manualRepository.findAll() : manualRepository.findById(id);
    }

    public List<Manual> createList(List<Manual> manuals) {
        return (List<Manual>) manualRepository.saveAll(manuals);
    }

    public Manual updateManual(Long id, Manual manual) {

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
        manualRepository.deleteById(id);
    }
}
