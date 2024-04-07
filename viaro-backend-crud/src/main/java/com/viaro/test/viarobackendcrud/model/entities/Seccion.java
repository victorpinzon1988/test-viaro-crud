package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Seccion")
public class Seccion {

    @EmbeddedId
    private SeccionKey seccionKey;
    @Column(name = "Active")
    private String active;

    public Seccion() {
    }

    public Seccion(SeccionKey seccionKey, String active) {
        this.seccionKey = seccionKey;
        this.active = active;
    }

    public SeccionKey getSeccionKey() {
        return seccionKey;
    }

    public void setSeccionKey(SeccionKey seccionKey) {
        this.seccionKey = seccionKey;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
