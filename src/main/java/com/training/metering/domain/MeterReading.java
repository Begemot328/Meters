package com.training.metering.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "meter_readings")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MeterReading extends CustomEntity {

    private Date changeDate;

    private double value;

    @Enumerated(EnumType.STRING)
    private MeterType type;

    private long userId;
}
