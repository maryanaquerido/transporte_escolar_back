package com.example.transporte_escolar_back.exceptions;

import com.example.transporte_escolar_back.dto.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<GenericResponse> handleUserNotFound(DriverNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse(false, ex.getMessage()));
    }

    @ExceptionHandler(DriverIsRegisteredException.class)
    public ResponseEntity<GenericResponse> handleUserIsRegistered(DriverIsRegisteredException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new GenericResponse(false, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherErrors() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "internal error"
        ));
    }
}
