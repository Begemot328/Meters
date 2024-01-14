package com.training.metering.service.validator;

import com.training.metering.domain.MeterReading;
import com.training.metering.persistence.MeterReadingRepository;
import com.training.metering.service.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotNullReadingValidator implements MeterReadingValidator {

    private final MeterReadingRepository repository;

    @Autowired
    public NotNullReadingValidator(MeterReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(MeterReading meterReading) throws ValidationException {
        if (meterReading.getType() == null) throw new ValidationException("Type cannot be null");
        if (meterReading.getUserId() == 0) throw new ValidationException("UserId cannot be null");
    }
}
