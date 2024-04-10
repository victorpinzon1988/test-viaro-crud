package com.viaro.test.viarobackendcrud.controller;

import com.viaro.test.viarobackendcrud.model.dto.TeacherDTO;
import com.viaro.test.viarobackendcrud.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO){
        log.info("Saving teacher: {}", teacherDTO);
        TeacherDTO teacherDTOResponse = teacherService.saveTeacher(teacherDTO);
        log.info("Teacher saved: {}", teacherDTOResponse);
        return new ResponseEntity<>(teacherDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable("id") Integer id,
                                                    @RequestBody TeacherDTO teacherDTO){

        log.info("Updating teacher with ID: {}", id);
        log.info("Teacher data: {}", teacherDTO);

        TeacherDTO teacherDTOResponse = teacherService.updateTeacher(id, teacherDTO);
        log.info("Teacher updated: {}", teacherDTOResponse.getIdProfesor());
        return new ResponseEntity<>(teacherDTOResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherDTO> removeTeacher(@PathVariable("id") Integer id){

        log.info("Removing teacher with ID: {}", id);
        teacherService.removeTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<TeacherDTO>> getStudents(Pageable pageable){

        log.info("Retrieving teachers");
        log.info("Page number: {}", pageable.getPageNumber());
        log.info("Page size: {}", pageable.getPageSize());

        List<TeacherDTO> teachers = teacherService.getAllTeachers(pageable);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
