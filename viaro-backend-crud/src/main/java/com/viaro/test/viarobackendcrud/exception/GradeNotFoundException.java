package com.viaro.test.viarobackendcrud.exception;

public class GradeNotFoundException extends RuntimeException{

    public GradeNotFoundException(String message){
        super(message);
    }
}
