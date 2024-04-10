package com.viaro.test.viarobackendcrud.model.mapper;

import com.viaro.test.viarobackendcrud.model.dto.SectionDTOResponse;
import com.viaro.test.viarobackendcrud.model.entities.Seccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = GradeResponseMapper.class)
public interface SectionResponseMapper {

    @Mapping(target = "idGrado", source = "seccionPKKey.grado")
    @Mapping(target = "idSeccion", source = "seccionPKKey.idSeccion")
    SectionDTOResponse toDTO(Seccion seccion);

    Seccion toEntity(SectionDTOResponse sectionDTOResponse);

    List<SectionDTOResponse> toListDTO(List<Seccion> seccionList);
}
