package com.gorbachyov.jsonpostgres.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingMatrixVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handle(MissingServletRequestParameterException ex) {
        return ResponseEntity.status(500).body(ex);
    }
}
