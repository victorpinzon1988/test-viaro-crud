package com.viaro.test.viarobackendcrud.model.mapper;

import com.viaro.test.viarobackendcrud.model.dto.TeacherDTO;
import com.viaro.test.viarobackendcrud.model.entities.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(target = "generoId", expression = "java(null)")
    Profesor toEntity(TeacherDTO teacherDTO);

    @Mapping(target = "genero", source = "profesor.generoId.descripcion")
    TeacherDTO toDTO(Profesor profesor);

    List<TeacherDTO> toListDTO(List<Profesor> profesores);
}
