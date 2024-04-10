package com.viaro.test.viarobackendcrud.repository;

import com.viaro.test.viarobackendcrud.model.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Alumno, Integer> {
}
