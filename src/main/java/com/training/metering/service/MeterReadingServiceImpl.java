package com.training.metering.service;

import com.training.metering.domain.MeterReading;
import com.training.metering.domain.MeterType;
import com.training.metering.persistence.MeterReadingRepository;
import com.training.metering.service.validator.MeterReadingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Service
@Validated
public class MeterReadingServiceImpl implements MeterReadingService {

    private final MeterReadingRepository repository;

    private final List<MeterReadingValidator> validators;

    @Autowired
    public MeterReadingServiceImpl(MeterReadingRepository repository, List<MeterReadingValidator> validators) {
        this.repository = repository;
        this.validators = validators;
    }

    @Override
    public void submit(@NotNull MeterReading meterReading) {
        validators.forEach(validator -> validator.validate(meterReading));
        meterReading.setChangeDate(new Date());
        repository.save(meterReading);
    }

    @Override
    public List<MeterReading> getReadings(@NotNull MeterType type, @NotNull Long userId) {
        return repository.findByTypeAndUserId(type, userId);
    }
}
