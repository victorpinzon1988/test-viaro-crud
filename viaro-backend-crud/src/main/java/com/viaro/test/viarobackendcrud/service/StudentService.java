package com.viaro.test.viarobackendcrud.service;

import com.viaro.test.viarobackendcrud.exception.StudentNotFoundException;
import com.viaro.test.viarobackendcrud.exception.GenderNotFoundException;
import com.viaro.test.viarobackendcrud.model.dto.StudentDTO;
import com.viaro.test.viarobackendcrud.model.entities.Alumno;
import com.viaro.test.viarobackendcrud.model.entities.Genero;
import com.viaro.test.viarobackendcrud.model.mapper.StudentMapper;
import com.viaro.test.viarobackendcrud.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    private StudentMapper studentMapper;
    private GenderService genderService;
    private StudentRepository studentRepository;

    public StudentDTO saveStudent(StudentDTO studentDTO){
        log.info("Saving student");
        Alumno student = studentMapper.toEntity(studentDTO);

        Optional<Genero> genderResult = genderService.findGenderByDescription(studentDTO.getGenero());

        if (genderResult.isPresent())
            student.setGenero(genderResult.get());
        else
            throw new GenderNotFoundException(String.format("Gender not found [%s]", studentDTO.getGenero()));

        student = studentRepository.save(student);

        return studentMapper.toDTO(student);
    }

    public void removeStudent(Integer id){
        Optional<Alumno> studentResponse = studentRepository.findById(id);

        if(studentResponse.isPresent()){
            log.debug("Student found with ID: {}", id);
            studentRepository.delete(studentResponse.get());
            log.debug("Student with ID {} removed", id);
        } else {
            throw new StudentNotFoundException(String.format("Student not found with ID [%s]", id));
        }
    }

    public List<StudentDTO> getAllStudents(Pageable pageable){
        Page<Alumno> pageStudents = studentRepository.findAll(pageable);
        log.debug("Students found {}", pageStudents.getTotalElements());
        return studentMapper.toListDTO(pageStudents.getContent());
    }

    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO){

        Alumno student = studentMapper.toEntity(studentDTO);

        Optional<Genero> genderResult = genderService.findGenderByDescription(studentDTO.getGenero());

        if (genderResult.isPresent()) {
            student.setGenero(genderResult.get());
            student.setIdAlumno(id);
            studentRepository.save(student);

            return studentMapper.toDTO(student);
        }else
            throw new GenderNotFoundException(String.format("Gender not found [%s]", studentDTO.getGenero()));


    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Autowired
    public void setGenderService(GenderService genderService) {
        this.genderService = genderService;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
