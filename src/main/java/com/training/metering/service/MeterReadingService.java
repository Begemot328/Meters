package com.training.metering.service;

import com.training.metering.domain.MeterReading;
import com.training.metering.domain.MeterType;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface MeterReadingService {
    void submit(@NotNull MeterReading meterReading);

    List<MeterReading> getReadings(@NotNull MeterType type, @NotNull Long userId);
}
