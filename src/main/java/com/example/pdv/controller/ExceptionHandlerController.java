package com.example.pdv.controller;

import com.example.pdv.dto.ApiExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.EntityFilterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionDTO> handleException(Exception e){
        ApiExceptionDTO apiExceptionDto = new ApiExceptionDTO("Erro interno no Servidor. Contate o Suporte.");

        return ResponseEntity.internalServerError().body(apiExceptionDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionDTO> handleApiExceptionDtoResponseEntity(
            MethodArgumentNotValidException e){

        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()){
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        ApiExceptionDTO apiExceptionDto = new ApiExceptionDTO(errors);
        return ResponseEntity.badRequest().body(apiExceptionDto);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException e){
        //notFound do response entity não aceita body.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
