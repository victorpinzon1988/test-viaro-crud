package com.viaro.test.viarobackendcrud.exception;

public class TeacherNotFoundException extends RuntimeException{

    public TeacherNotFoundException(String message){
        super(message);
    }
}
