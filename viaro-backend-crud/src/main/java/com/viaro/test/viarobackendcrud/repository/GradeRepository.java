package com.viaro.test.viarobackendcrud.repository;

import com.viaro.test.viarobackendcrud.model.entities.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grado, Integer> {
}
