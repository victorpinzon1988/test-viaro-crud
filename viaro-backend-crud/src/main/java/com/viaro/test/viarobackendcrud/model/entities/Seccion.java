package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Seccion")
public class Seccion {

    @EmbeddedId
    private SeccionPKKey seccionPKKey;
    @Column(name = "Active")
    private String active;

    public Seccion() {
    }

    public Seccion(SeccionPKKey seccionPKKey, String active) {
        this.seccionPKKey = seccionPKKey;
        this.active = active;
    }

    public SeccionPKKey getSeccionPKKey() {
        return seccionPKKey;
    }

    public void setSeccionPKKey(SeccionPKKey seccionPKKey) {
        this.seccionPKKey = seccionPKKey;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
