package com.oop.practice.repository;

import com.oop.practice.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InspectionRepository  extends JpaRepository<Inspection, Integer> {

    @Query(value = "SELECT * FROM inspections WHERE EXTRACT(DOW FROM date_inspection) BETWEEN 1 AND 5 ORDER BY date_inspection", nativeQuery = true)
    List<Inspection> groupByDayOfWeek();


}
