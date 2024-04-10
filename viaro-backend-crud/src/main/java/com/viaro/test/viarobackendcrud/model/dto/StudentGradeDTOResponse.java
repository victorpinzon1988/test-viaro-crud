package com.viaro.test.viarobackendcrud.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StudentGradeDTOResponse {

    private StudentDTO student;
    private SectionDTOResponse section;
}
