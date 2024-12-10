package com.oop.practice.repository;

import com.oop.practice.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository  extends JpaRepository<Inspection, Integer> {

}
