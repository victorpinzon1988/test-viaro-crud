package com.viaro.test.viarobackendcrud.model.mapper;

import com.viaro.test.viarobackendcrud.model.dto.GradeDTOResponse;
import com.viaro.test.viarobackendcrud.model.entities.Grado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TeacherMapper.class)
public interface GradeResponseMapper {

    GradeDTOResponse toDTO(Grado grado);

    Grado toEntity(GradeDTOResponse gradeDTOResponse);

    List<GradeDTOResponse> toListDTO(List<Grado> gradoList);
}
