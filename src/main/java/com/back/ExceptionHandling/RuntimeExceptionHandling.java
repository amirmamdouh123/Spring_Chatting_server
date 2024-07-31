package com.back.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RuntimeExceptionHandling {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionBody> ExceptionHandle( RuntimeException r ){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new ExceptionBody(r.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value()));
    }
}
