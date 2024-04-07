package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdProfesor")
    private Integer idProfesor;
    @Column(name = "PrimerNombre")
    private String primerNombre;

    @Column(name = "SegundoNombre")
    private String segundoNombre;
    @Column(name = "TercerNombre")
    private String tercerNombre;
    @Column(name = "PrimerApellido")
    private String primerApellido;
    @Column(name = "SegundoApellido")
    private String segundoApellido;

    @OneToOne
    private Genero generoId;
    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "profesor")
    private List<Grado> grados;

    public Profesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(Integer idProfesor, String primerNombre, String segundoNombre, String tercerNombre, String primerApellido, String segundoApellido, Genero generoId, LocalDate fechaNacimiento) {
        this.idProfesor = idProfesor;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.tercerNombre = tercerNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.generoId = generoId;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Genero getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Genero generoId) {
        this.generoId = generoId;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", tercerNombre='" + tercerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", generoId=" + generoId +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
