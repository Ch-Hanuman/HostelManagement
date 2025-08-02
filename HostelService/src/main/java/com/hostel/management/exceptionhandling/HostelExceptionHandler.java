package com.hostel.management.exceptionhandling;

import com.hostel.management.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HostelExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(ResourceNotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(false, HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }
}
