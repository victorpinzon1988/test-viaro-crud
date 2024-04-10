package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class SeccionPKKey implements Serializable {

    @ManyToOne
    private Grado grado;
    private String idSeccion;

    public SeccionPKKey() {
    }

    public SeccionPKKey(Grado grado, String idSeccion) {
        this.grado = grado;
        this.idSeccion = idSeccion;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }
}
