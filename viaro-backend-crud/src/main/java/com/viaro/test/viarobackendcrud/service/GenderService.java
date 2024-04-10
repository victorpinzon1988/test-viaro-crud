package com.viaro.test.viarobackendcrud.service;

import com.viaro.test.viarobackendcrud.model.dto.GenderDTO;
import com.viaro.test.viarobackendcrud.model.entities.Genero;
import com.viaro.test.viarobackendcrud.model.mapper.GenderMapperImpl;
import com.viaro.test.viarobackendcrud.repository.GenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GenderService {

    private GenderRepository genderRepository;
    private GenderMapperImpl genderMapper;

    public List<GenderDTO> findAllGenders(){
        log.info("Retrieving genders available");
        List<Genero> genders = genderRepository.findAll();

        log.info("Size genders available: {}", genders.size());

        genders.forEach(System.out::println);
        return genderMapper.listGeneroToListDTO(genders);
    }

    public Optional<Genero> findGenderByDescription(String description){
        log.info("Gender Description {}", description);
        return Optional.ofNullable(genderRepository.findByDescripcion(description.toUpperCase()));
    }

    @Autowired
    public void setGenderRepository(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Autowired
    public void setGenderMapper(GenderMapperImpl genderMapper) {
        this.genderMapper = genderMapper;
    }
}
