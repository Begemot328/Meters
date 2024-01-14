package com.training.metering.web.exceptionhandler;

import com.training.metering.service.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ExceptionDTO> handleValidationException(
            ValidationException ex) {
        return new ResponseEntity<>(new ExceptionDTO(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ExceptionDTO> handleConstraintViolationException(
            ConstraintViolationException ex) {
        return new ResponseEntity<>(new ExceptionDTO(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionDTO> handleException(
            Exception ex) {
        return new ResponseEntity<>(new ExceptionDTO(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
