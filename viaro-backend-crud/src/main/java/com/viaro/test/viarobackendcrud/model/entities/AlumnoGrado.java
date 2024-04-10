package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "AlumnoGrado")
public class AlumnoGrado {

    @EmbeddedId
    private AlumnoGradoPKKey alumnoGradoPKKey;

    public AlumnoGrado() {
    }

    public AlumnoGrado(AlumnoGradoPKKey alumnoGradoPKKey) {
        this.alumnoGradoPKKey = alumnoGradoPKKey;
    }

    public AlumnoGradoPKKey getAlumnoGradoKey() {
        return alumnoGradoPKKey;
    }

    public void setAlumnoGradoKey(AlumnoGradoPKKey alumnoGradoPKKey) {
        this.alumnoGradoPKKey = alumnoGradoPKKey;
    }
}
