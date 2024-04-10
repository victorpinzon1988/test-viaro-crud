package com.viaro.test.viarobackendcrud.exception;

import com.viaro.test.viarobackendcrud.model.pojo.ErrorResponseViaro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GenderNotFoundException.class,
            StudentNotFoundException.class,
            TeacherNotFoundException.class,
            GradeNotFoundException.class})
    protected ResponseEntity<ErrorResponseViaro> handleEntityNotFound(RuntimeException ex){
        ErrorResponseViaro restError = new ErrorResponseViaro(HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ex.getMessage());
        return new ResponseEntity<>(restError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TeacherHasGradesException.class,
            GradeHasSectionsException.class})
    protected ResponseEntity<ErrorResponseViaro> handleCannotRemove(RuntimeException ex){
        ErrorResponseViaro restError = new ErrorResponseViaro(HttpStatus.PRECONDITION_FAILED,
                HttpStatus.PRECONDITION_FAILED.value(),
                LocalDateTime.now(),
                ex.getMessage());
        return new ResponseEntity<>(restError, HttpStatus.PRECONDITION_FAILED);

    }




}
