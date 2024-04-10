package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SectionDTOResponse {

    private GradeDTOResponse idGrado;
    private String idSeccion;

}
