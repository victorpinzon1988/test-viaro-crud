package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer idAlumno;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private LocalDate fechaNacimiento;

}
