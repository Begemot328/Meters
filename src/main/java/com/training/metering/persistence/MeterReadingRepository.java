package com.training.metering.persistence;

import com.training.metering.domain.MeterReading;
import com.training.metering.domain.MeterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {

    @Query(value = "select m from MeterReading m where m.type = ?1 and m.userId = ?2")
    List<MeterReading> findByTypeAndUserId(MeterType type, Long userId);

    @Query(value = "select MAX(m2.value) from MeterReading m2 where m2.type = ?1 and m2.userId = ?2")
    Double findTopByValueAndAndTypeAndUserId(MeterType type, Long userId);
}
