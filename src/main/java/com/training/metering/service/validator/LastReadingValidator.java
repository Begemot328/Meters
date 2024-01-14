package com.training.metering.service.validator;

import com.training.metering.domain.MeterReading;
import com.training.metering.persistence.MeterReadingRepository;
import com.training.metering.service.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LastReadingValidator implements MeterReadingValidator {

    private final MeterReadingRepository repository;

    @Autowired
    public LastReadingValidator(MeterReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(MeterReading meterReading) throws ValidationException {

        Double maxValue = repository.findTopByValueAndAndTypeAndUserId(meterReading.getType(), meterReading.getUserId());
//        Double maxValue = repository.findByTypeAndUserIdAndOrderById(meterReading.getType(), meterReading.getUserId()).getValue();
        if (maxValue > meterReading.getValue())
            throw new ValidationException(String.format("Value is less then maxValue = %s", maxValue));
    }
}
