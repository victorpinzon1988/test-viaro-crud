package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GradeDTOResponse {

    private Integer idGrado;
    private String nombreGrado;
    private TeacherDTO profesor;
}
