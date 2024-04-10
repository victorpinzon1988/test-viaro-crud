package com.viaro.test.viarobackendcrud.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "alumnoGradoPKKey.alumnoId")
    private List<AlumnoGrado> alumnoGradoList;

    public Alumno() {
    }

    public Alumno(Integer idAlumno, String primerNombre, String segundoNombre, String tercerNombre, String primerApellido, String segundoApellido, Genero generoId, LocalDate fechaNacimiento) {
        this.idAlumno = idAlumno;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.tercerNombre = tercerNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.generoId = generoId;
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


    public Genero getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Genero generoId) {
        this.generoId = generoId;
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
                ", generoId=" + generoId +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
