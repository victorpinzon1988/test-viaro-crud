package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GradeDTORequest {

    private Integer idGrado;
    private String nombreGrado;
    private Integer profesorID;
}
