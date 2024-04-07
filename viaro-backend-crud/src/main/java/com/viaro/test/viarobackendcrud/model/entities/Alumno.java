package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdAlumno")
    private Integer idAlumno;
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

    public Alumno() {
    }

    public Alumno(Integer idAlumno, String primerNombre, String segundoNombre, String tercerNombre, String primerApellido, String segundoApellido, Genero genero, LocalDate fechaNacimiento) {
        this.idAlumno = idAlumno;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.tercerNombre = tercerNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        generoId = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
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

    public Genero getGenero() {
        return generoId;
    }

    public void setGenero(Genero genero) {
        generoId = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", tercerNombre='" + tercerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", Genero=" + generoId +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
