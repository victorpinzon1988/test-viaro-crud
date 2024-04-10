package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class AlumnoGradoPKKey implements Serializable {

    @ManyToOne
    private Alumno alumnoId;
    private SeccionPKKey seccionPKKey;

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public SeccionPKKey getSeccionPKKey() {
        return seccionPKKey;
    }

    public void setSeccionPKKey(SeccionPKKey seccionPKKey) {
        this.seccionPKKey = seccionPKKey;
    }
}
