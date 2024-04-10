package com.viaro.test.viarobackendcrud.controller;

import com.viaro.test.viarobackendcrud.model.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.viaro.test.viarobackendcrud.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
        log.info("Saving student: {}", studentDTO);
        StudentDTO studentDTOResponse = studentService.saveStudent(studentDTO);
        log.info("Student saved: {}", studentDTOResponse);
        return new ResponseEntity<>(studentDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") Integer id,
                                                    @RequestBody StudentDTO studentDTO){
        log.info("Updating student with ID: {}", id);
        log.info("Student data: {}", studentDTO);

        StudentDTO studentDTOResponse = studentService.updateStudent(id, studentDTO);
        log.info("Student updated: {}", studentDTOResponse.getIdAlumno());
        return new ResponseEntity<>(studentDTOResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> removeStudent(@PathVariable("id") Integer id){

        log.info("Removing student with ID: {}", id);
        studentService.removeStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<StudentDTO>> getStudents(Pageable pageable){
        log.info("Retrieving students");
        log.info("Page number: {}", pageable.getPageNumber());
        log.info("Page Size: {}", pageable.getPageSize());
        List<StudentDTO> students = studentService.getAllStudents(pageable);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
