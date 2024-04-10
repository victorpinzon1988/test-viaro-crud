package com.viaro.test.viarobackendcrud.model.mapper;

import com.viaro.test.viarobackendcrud.model.dto.StudentDTO;
import com.viaro.test.viarobackendcrud.model.entities.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "genero", expression = "java(null)")
    Alumno toEntity(StudentDTO studentDTO);
    @Mapping(target = "genero", source = "alumno.genero.descripcion")
    StudentDTO toDTO(Alumno alumno);
    List<StudentDTO> toListDTO(List<Alumno> alumnoList);
}
