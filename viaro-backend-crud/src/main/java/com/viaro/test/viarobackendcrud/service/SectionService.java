package com.viaro.test.viarobackendcrud.service;

import com.viaro.test.viarobackendcrud.exception.GradeNotFoundException;
import com.viaro.test.viarobackendcrud.model.dto.SectionDTORequest;
import com.viaro.test.viarobackendcrud.model.dto.SectionDTOResponse;
import com.viaro.test.viarobackendcrud.model.entities.Grado;
import com.viaro.test.viarobackendcrud.model.entities.Seccion;
import com.viaro.test.viarobackendcrud.model.entities.SeccionPKKey;
import com.viaro.test.viarobackendcrud.model.mapper.SectionResponseMapperImpl;
import com.viaro.test.viarobackendcrud.repository.GradeRepository;
import com.viaro.test.viarobackendcrud.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SectionService {

    private GradeRepository gradeRepository;
    private SectionRepository sectionRepository;
    private SectionResponseMapperImpl sectionResponseMapper;

    private SectionDTOResponse saveSection(SectionDTORequest sectionDTORequest){
        Seccion section = new Seccion();
        log.debug("Saving section");

        Grado grade = getGrade(sectionDTORequest.getIdGrado());

        SeccionPKKey pkKey = new SeccionPKKey();
        pkKey.setGrado(grade);
        pkKey.setIdSeccion(sectionDTORequest.getIdSeccion());

        section.setSeccionPKKey(pkKey);
        section.setActive("A");

        section = sectionRepository.save(section);

        return sectionResponseMapper.toDTO(section);
    }

    private void removeSection(Integer idGrade, String idSection){

        log.debug("Removing section");

        Grado grade = getGrade(idGrade);

        SeccionPKKey pkKey = new SeccionPKKey();
        pkKey.setGrado(grade);
        pkKey.setIdSeccion(idSection);

        Seccion section = getSection(pkKey);
        sectionRepository.delete(section);

        log.debug("Section {} {} was deleted ", idGrade, idSection);

    }

    private List<SectionDTOResponse> getSections(Pageable pageable){

        log.debug("Retrieving sections");
        Page<Seccion> sectionPage = sectionRepository.findAll(pageable);
        log.debug("Sections found {}", sectionPage.getTotalElements());
        return sectionResponseMapper.toListDTO(sectionPage.getContent());
    }

    public SectionDTOResponse updateSection(Integer idGrade,
                                            String idSection,
                                            SectionDTORequest sectionDTORequest){

        log.debug("Updating section");

        Grado originalGrade = getGrade(idGrade);

        SeccionPKKey pkKey = new SeccionPKKey();
        pkKey.setGrado(originalGrade);
        pkKey.setIdSeccion(idSection);

        Seccion section = getSection(pkKey);

        log.debug("Retrieving updated values");
        Grado newGrade = getGrade(sectionDTORequest.getIdGrado());
        section.getSeccionPKKey().setGrado(newGrade);
        section.getSeccionPKKey().setIdSeccion(idSection);
        section.setActive("A");

        section = sectionRepository.save(section);

        log.debug("Section {} {} was updated",
                section.getSeccionPKKey().getGrado().getIdGrado(),
                section.getSeccionPKKey().getIdSeccion());

        return sectionResponseMapper.toDTO(section);

    }

    private Grado getGrade(Integer idGrade){

        Optional<Grado> gradeResponse = gradeRepository.findById(idGrade);

        if (gradeResponse.isEmpty()){
            throw new GradeNotFoundException(String.format("Grade %s was not found",
                    idGrade));
        }else {
            log.debug("Grade {} was found", idGrade);
            return gradeResponse.get();
        }
    }

    private Seccion getSection(SeccionPKKey seccionPKKey){

        Optional<Seccion> sectionResponse = sectionRepository.findById(seccionPKKey);

        if(sectionResponse.isEmpty()){
            throw new GradeNotFoundException(String.format("Section %s %s was not found",
                    seccionPKKey.getGrado().getIdGrado(),
                    seccionPKKey.getIdSeccion()));
        }else{
            log.debug("Section {} {} was found",
                    seccionPKKey.getGrado().getIdGrado(),
                    seccionPKKey.getIdSeccion());

            return sectionResponse.get();
        }
    }

    @Autowired
    public void setGradeRepository(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Autowired
    public void setSectionRepository(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Autowired
    public void setSectionResponseMapper(SectionResponseMapperImpl sectionResponseMapper) {
        this.sectionResponseMapper = sectionResponseMapper;
    }
}
