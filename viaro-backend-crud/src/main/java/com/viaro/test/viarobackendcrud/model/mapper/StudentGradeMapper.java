package com.viaro.test.viarobackendcrud.model.mapper;

import com.viaro.test.viarobackendcrud.model.dto.StudentGradeDTOResponse;
import com.viaro.test.viarobackendcrud.model.entities.AlumnoGrado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SectionResponseMapper.class})
public interface StudentGradeMapper {

    @Mapping(target = "student", source = "alumnoGradoKey.alumnoId")
    @Mapping(target = "section", source = "alumnoGradoKey.seccionPKKey")
    StudentGradeDTOResponse toDTO(AlumnoGrado studentGrade);

    AlumnoGrado toEntity(StudentGradeDTOResponse studentGradeDTOResponse);
}
