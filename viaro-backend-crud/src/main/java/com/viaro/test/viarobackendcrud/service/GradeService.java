package com.viaro.test.viarobackendcrud.service;

import com.viaro.test.viarobackendcrud.exception.GradeHasSectionsException;
import com.viaro.test.viarobackendcrud.exception.GradeNotFoundException;
import com.viaro.test.viarobackendcrud.exception.TeacherNotFoundException;
import com.viaro.test.viarobackendcrud.model.dto.GradeDTORequest;
import com.viaro.test.viarobackendcrud.model.dto.GradeDTOResponse;
import com.viaro.test.viarobackendcrud.model.dto.TeacherDTO;
import com.viaro.test.viarobackendcrud.model.entities.Grado;
import com.viaro.test.viarobackendcrud.model.entities.Profesor;
import com.viaro.test.viarobackendcrud.model.mapper.GradeResponseMapperImpl;
import com.viaro.test.viarobackendcrud.repository.GradeRepository;
import com.viaro.test.viarobackendcrud.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class GradeService {

    private TeacherRepository teacherRepository;

    private GradeRepository gradeRepository;

    private GradeResponseMapperImpl gradeResponseMapper;

    public GradeDTOResponse saveGrade(GradeDTORequest gradeDTORequest){

        Grado grado = new Grado();
        log.debug("Saving grade");

        Optional<Profesor> teacherResponse = teacherRepository.findById(gradeDTORequest.getProfesorID());

        if(teacherResponse.isPresent()){
            grado.setNombreGrado(gradeDTORequest.getNombreGrado());
            grado.setProfesor(teacherResponse.get());
            grado = gradeRepository.save(grado);
            return gradeResponseMapper.toDTO(grado);
        }else{
            throw new TeacherNotFoundException(String.format("Teacher not found %s", gradeDTORequest.getIdGrado()));
        }
    }

    public void removeGrade(Integer id){
        log.debug("Removing grade");

        Optional<Grado> gradeResponse = gradeRepository.findById(id);

        if(gradeResponse.isPresent() && gradeResponse.get().getSeccionList().isEmpty()){
            log.debug("Grade with ID {} found", id);
            gradeRepository.delete(gradeResponse.get());
            log.debug("Grade with ID {} removed", id);
        }else if (gradeResponse.isPresent() && !gradeResponse.get().getSeccionList().isEmpty()){
            throw new GradeHasSectionsException(String.format("Grade with ID %s has sections assigned", id));
        }else{
            throw new GradeNotFoundException(String.format("Grade with ID %s not found", id));
        }
    }

    public List<GradeDTOResponse> getGrades(Pageable pageable){

        log.debug("Retrieving grades");
        Page<Grado> gradesPage = gradeRepository.findAll(pageable);
        log.debug("Grades found {}", gradesPage.getTotalElements());
        return gradeResponseMapper.toListDTO(gradesPage.getContent());
    }

    public GradeDTOResponse updateGrade(Integer id, GradeDTORequest gradeDTORequest){

        log.debug("Updating grade");

        Optional<Grado> gradeResponse = gradeRepository.findById(id);

        if(gradeResponse.isPresent()){

            Grado grade = gradeResponse.get();
            if (!Objects.equals(grade.getProfesor().getIdProfesor(), gradeDTORequest.getProfesorID())){

                Optional<Profesor> teacherResponse = teacherRepository.findById(gradeDTORequest.getProfesorID());

                if(teacherResponse.isEmpty()){
                    throw new TeacherNotFoundException(String.format("Teacher with ID %s was not found",
                            gradeDTORequest.getProfesorID()));
                }

                grade.setProfesor(teacherResponse.get());
            }
            grade.setNombreGrado(gradeDTORequest.getNombreGrado());
            grade.setIdGrado(id);

            gradeRepository.save(grade);

            return gradeResponseMapper.toDTO(grade);

        }else{
            throw new GradeNotFoundException(String.format("Grade with ID %s was not found", id));
        }
    }

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setGradeRepository(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Autowired
    public void setGradeResponseMapper(GradeResponseMapperImpl gradeResponseMapper) {
        this.gradeResponseMapper = gradeResponseMapper;
    }
}
