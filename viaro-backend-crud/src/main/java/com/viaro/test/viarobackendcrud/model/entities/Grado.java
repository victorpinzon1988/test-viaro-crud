package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Grado")
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGrado;

    @Column(name = "NombreGrado")
    private String nombreGrado;
    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy = "seccionPKKey.grado")
    private List<Seccion> seccionList;

    public Grado() {
    }

    public Grado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Grado(Integer idGrado, String nombreGrado, Profesor profesor) {
        this.idGrado = idGrado;
        this.nombreGrado = nombreGrado;
        this.profesor = profesor;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Seccion> getSeccionList() {
        return seccionList;
    }

    public void setSeccionList(List<Seccion> seccionList) {
        this.seccionList = seccionList;
    }

    @Override
    public String toString() {
        return "Grado{" +
                "idGrado=" + idGrado +
                ", nombreGrado='" + nombreGrado + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
