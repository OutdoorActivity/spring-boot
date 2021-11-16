package com.gorbachyov.jsonpostgres.repositories;

import com.gorbachyov.jsonpostgres.entities.Manual;
import org.springframework.data.repository.CrudRepository;

public interface ManualRepository extends CrudRepository<Manual, Long> {
}
