package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class AlumnoGradoKey implements Serializable {

    @ManyToOne
    private Alumno alumnoId;
    private SeccionKey seccionKey;
}
