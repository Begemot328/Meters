package com.training.metering.service.validator;

import com.training.metering.service.exception.ValidationException;

public interface Validator<T> {

    void validate(T t) throws ValidationException;
}
