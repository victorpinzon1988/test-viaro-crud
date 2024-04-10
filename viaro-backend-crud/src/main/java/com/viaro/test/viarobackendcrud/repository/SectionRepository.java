package com.viaro.test.viarobackendcrud.repository;

import com.viaro.test.viarobackendcrud.model.entities.Seccion;
import com.viaro.test.viarobackendcrud.model.entities.SeccionPKKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Seccion, SeccionPKKey> {
}
