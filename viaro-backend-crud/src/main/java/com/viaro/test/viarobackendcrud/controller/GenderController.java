package com.viaro.test.viarobackendcrud.controller;

import com.viaro.test.viarobackendcrud.model.dto.GenderDTO;
import com.viaro.test.viarobackendcrud.service.GenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender")
@Slf4j
public class GenderController {

    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<GenderDTO>> obtenerGeneros(){
        log.info("Retrieving available genders");
        List<GenderDTO> genders = genderService.findAllGenders();

        log.info("Size genders found: {}", genders.size());
        genders.forEach(gender -> log.info("Gender: {}", gender));

        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @Autowired
    public void setGenderService(GenderService genderService) {
        this.genderService = genderService;
    }
}
