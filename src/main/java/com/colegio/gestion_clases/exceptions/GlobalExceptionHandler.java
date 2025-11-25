package com.colegio.gestion_clases.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.colegio.gestion_clases.utils.DateFormatterUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(), 
                    HttpStatus.NOT_FOUND.name(),
                    ex.getMessage(), 
                    DateFormatterUtil.format(LocalDateTime.now())
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        
        List<String> messages = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(err -> err.getField() + ": " + err.getDefaultMessage())
            .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                    HttpStatus.BAD_REQUEST.value(), 
                    HttpStatus.BAD_REQUEST.name(), 
                    messages,
                    DateFormatterUtil.format(LocalDateTime.now()
                )));
    }    

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleInvalidFormat(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                    400, 
                    "Invalid date format", 
                    "Fiel date need the next format: YYYY-mm-dd", 
                    LocalDateTime.now().toString()
                ));
    }
}
