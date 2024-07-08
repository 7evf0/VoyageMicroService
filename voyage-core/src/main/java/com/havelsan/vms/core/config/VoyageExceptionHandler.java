package com.havelsan.vms.core.config;

import com.havelsan.vms.core.config.exception.ClassExistsException;
import com.havelsan.vms.core.config.exception.ClassNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VoyageExceptionHandler {

    @ExceptionHandler(ClassExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleClassExists(ClassExistsException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ClassNotExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleClassNotExists(ClassNotExistsException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
