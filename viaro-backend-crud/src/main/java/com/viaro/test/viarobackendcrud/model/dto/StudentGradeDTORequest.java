package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StudentGradeDTORequest {

    private Integer alumnoId;
    private Integer idGrado;
    private Integer idSeccion;
}
