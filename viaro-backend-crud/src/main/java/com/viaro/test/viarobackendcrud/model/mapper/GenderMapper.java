package com.viaro.test.viarobackendcrud.model.mapper;

import com.viaro.test.viarobackendcrud.model.dto.GenderDTO;
import com.viaro.test.viarobackendcrud.model.entities.Genero;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    GenderDTO generoToDTO(Genero genero);

    List<GenderDTO> listGeneroToListDTO(List<Genero> generoList);
}
