package com.viaro.test.viarobackendcrud.controller;

import com.viaro.test.viarobackendcrud.model.dto.GradeDTORequest;
import com.viaro.test.viarobackendcrud.model.dto.GradeDTOResponse;
import com.viaro.test.viarobackendcrud.service.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
@Slf4j
public class GradeController {

    private GradeService gradeService;

    @PostMapping
    public ResponseEntity<GradeDTOResponse> saveGrade(@RequestBody GradeDTORequest gradeDTORequest){

        log.debug("Saving grade {} with teacher {}", gradeDTORequest.getIdGrado(),
                gradeDTORequest.getProfesorID());
        GradeDTOResponse gradeDTOResponse = gradeService.saveGrade(gradeDTORequest);
        return new ResponseEntity<>(gradeDTOResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeDTOResponse> updateGrade(@PathVariable("id") Integer id,
                                                        @RequestBody GradeDTORequest gradeDTORequest){

        log.info("Updating grade with ID: {}", id);
        log.info("Grade data: {}", gradeDTORequest);

        GradeDTOResponse gradeDTOResponse = gradeService.updateGrade(id, gradeDTORequest);
        log.info("Grade updated: {}", gradeDTOResponse.getIdGrado());

        return new ResponseEntity<>(gradeDTOResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GradeDTOResponse> removeGrade(@PathVariable("id") Integer id){
        log.info("Removing grade with ID: {}", id);
        gradeService.removeGrade(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<GradeDTOResponse>> getGrades(Pageable pageable){

        log.info("Retrieving grades");
        log.info("Page number: {}", pageable.getPageNumber());
        log.info("Page size: {}", pageable.getPageSize());

        List<GradeDTOResponse> grades = gradeService.getGrades(pageable);
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }
}
