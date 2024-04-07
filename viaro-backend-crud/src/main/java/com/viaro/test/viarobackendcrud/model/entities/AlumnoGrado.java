package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "AlumnoGrado")
public class AlumnoGrado {

    @EmbeddedId
    private AlumnoGradoKey alumnoGradoKey;

    public AlumnoGrado() {
    }

    public AlumnoGrado(AlumnoGradoKey alumnoGradoKey) {
        this.alumnoGradoKey = alumnoGradoKey;
    }

    public AlumnoGradoKey getAlumnoGradoKey() {
        return alumnoGradoKey;
    }

    public void setAlumnoGradoKey(AlumnoGradoKey alumnoGradoKey) {
        this.alumnoGradoKey = alumnoGradoKey;
    }
}
