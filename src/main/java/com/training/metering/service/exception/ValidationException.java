package com.training.metering.service.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String s) {
        super(s);
    }

    public ValidationException(Exception e) {
        super(e);
    }
}
