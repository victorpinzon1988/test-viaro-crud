package com.viaro.test.viarobackendcrud.repository;

import com.viaro.test.viarobackendcrud.model.entities.AlumnoGrado;
import com.viaro.test.viarobackendcrud.model.entities.AlumnoGradoPKKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoGradoRepository extends JpaRepository<AlumnoGrado, AlumnoGradoPKKey> {
}
