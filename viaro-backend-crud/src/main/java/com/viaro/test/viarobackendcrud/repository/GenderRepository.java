package com.viaro.test.viarobackendcrud.repository;

import com.viaro.test.viarobackendcrud.model.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Genero, Integer> {

    public Genero findByDescripcion(String descripcion);
}
