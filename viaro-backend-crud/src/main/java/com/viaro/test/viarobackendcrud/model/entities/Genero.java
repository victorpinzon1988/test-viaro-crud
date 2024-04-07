package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Genero")
public class Genero {
    @Id
    @Column(name = "IdGenero")
    private String IdGenero;
    @Column(name = "Descripcion")
    private String descripcion;

    public Genero() {
    }

    public Genero(String idGenero, String descripcion) {
        IdGenero = idGenero;
        this.descripcion = descripcion;
    }

    public String getIdGenero() {
        return IdGenero;
    }

    public void setIdGenero(String idGenero) {
        IdGenero = idGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "IdGenero='" + IdGenero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
