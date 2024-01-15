package com.training.metering.web.controller;

import com.training.metering.domain.MeterReading;
import com.training.metering.domain.MeterType;
import com.training.metering.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/meters")
public class MeterReadingController {

    private MeterReadingService service;

    @Autowired
    public MeterReadingController(MeterReadingService service) {
        this.service = service;
    }

    @PostMapping(value = "/submit")
    public ResponseEntity<Void> submit(@RequestBody MeterReading meterReading) {
        service.submit(meterReading);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<List<MeterReading>> find(@RequestParam(value = "type", required = false) MeterType type, @RequestParam(value = "userId", required = false) Long userId) {
        return new ResponseEntity<>(service.getReadings(type, userId), HttpStatus.OK);
    }
}
