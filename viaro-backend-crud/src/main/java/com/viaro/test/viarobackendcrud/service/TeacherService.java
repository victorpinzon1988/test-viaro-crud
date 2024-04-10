package com.viaro.test.viarobackendcrud.service;

import com.viaro.test.viarobackendcrud.exception.GenderNotFoundException;
import com.viaro.test.viarobackendcrud.exception.TeacherHasGradesException;
import com.viaro.test.viarobackendcrud.exception.TeacherNotFoundException;
import com.viaro.test.viarobackendcrud.model.dto.TeacherDTO;
import com.viaro.test.viarobackendcrud.model.entities.Genero;
import com.viaro.test.viarobackendcrud.model.entities.Profesor;
import com.viaro.test.viarobackendcrud.model.mapper.TeacherMapperImpl;
import com.viaro.test.viarobackendcrud.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherService {

    private TeacherMapperImpl teacherMapper;

    private GenderService genderService;
    private TeacherRepository teacherRepository;

    public TeacherDTO saveTeacher(TeacherDTO teacherDTO) {
        log.info("Saving teacher");

        Profesor teacher = teacherMapper.toEntity(teacherDTO);

        Optional<Genero> genderResult = genderService.findGenderByDescription(teacherDTO.getGenero());

        if (genderResult.isPresent())
            teacher.setGeneroId(genderResult.get());
        else
            throw new TeacherNotFoundException(String.format("Gender not found [%s]", teacherDTO.getGenero()));

        teacher = teacherRepository.save(teacher);

        return teacherMapper.toDTO(teacher);

    }

    public void removeTeacher(Integer id){
        Optional<Profesor> teacherResponse = teacherRepository.findById(id);

        if(teacherResponse.isPresent() && teacherResponse.get().getGrados().isEmpty()){
            log.debug("Teacher found {}", id);
            teacherRepository.delete(teacherResponse.get());
            log.debug("Teacher removed {}", id);
        } else if(teacherResponse.isPresent() && !teacherResponse.get().getGrados().isEmpty()){
            throw new TeacherHasGradesException(String.format("Teacher with ID %d cannot be removed because has grades assigned", id));
        }else{
            throw new TeacherNotFoundException(String.format("Teacher not found %s", id));
        }
    }

    public TeacherDTO updateTeacher(Integer id, TeacherDTO teacherDTO){

        Profesor teacher = teacherMapper.toEntity(teacherDTO);

        Optional<Genero> genderResult = genderService.findGenderByDescription(teacherDTO.getGenero());

        if(genderResult.isPresent()){
            teacher.setGeneroId(genderResult.get());
            teacher.setIdProfesor(id);
            teacherRepository.save(teacher);

            return teacherMapper.toDTO(teacher);
        }else{
            throw new GenderNotFoundException(String.format("Gender not found [%s]", teacherDTO.getGenero()));
        }
    }

    public List<TeacherDTO> getAllTeachers(Pageable pageable){

        Page<Profesor> teacherPage = teacherRepository.findAll(pageable);
        log.debug("Teachers found {}", teacherPage.getTotalElements());
        return teacherMapper.toListDTO(teacherPage.getContent());

    }

    @Autowired
    public void setTeacherMapper(TeacherMapperImpl teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Autowired
    public void setGenderService(GenderService genderService) {
        this.genderService = genderService;
    }

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
}
