package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TeacherDTO {

    private Integer idProfesor;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private LocalDate fechaNacimiento;
}
