package com.oop.practice.service;

import com.oop.practice.dto.InspectionDTO;
import com.oop.practice.entity.Inspection;
import com.oop.practice.repository.InspectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.*;

@Service
public class InspectionService {
    @Autowired
    private InspectionRepository inspectionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public InspectionDTO convertToDto(Inspection inspection){
        return modelMapper.map(inspection, InspectionDTO.class);
    }

    public Inspection convertToEntity(InspectionDTO inspectionDTO) {
        return modelMapper.map(inspectionDTO, Inspection.class);
    }

    public Inspection save(Inspection inspection) {
        return inspectionRepository.save(inspection);
    }

    public List<Inspection> getAllInspection() {
        return inspectionRepository.findAll();
    }

    public InspectionDTO getInspectionById(int id) {
        Inspection inspection = inspectionRepository.findById(id).orElseThrow(() -> new RuntimeException("inspection not found"));
        return convertToDto(inspection);
    }

    public InspectionDTO updateInspection(int id, InspectionDTO inspectionDTO) {
        Inspection existingInspection= inspectionRepository.findById(id).orElseThrow(() -> new RuntimeException("inspection not found"));
        existingInspection.setNameAttraction(inspectionDTO.getNameAttraction());
        existingInspection.setNumberInspetion(inspectionDTO.getNumberInspetion());
        existingInspection.setDateInspection(inspectionDTO.getDateInspection());
        existingInspection.setTypeInspection(inspectionDTO.getTypeInspection());
        existingInspection.setLocationAttraction(inspectionDTO.getLocationAttraction());
        Inspection updatedInspection = inspectionRepository.save(existingInspection);
        return convertToDto(updatedInspection);
    }

    public void deleteInspection(int id) {
        Inspection inspection = inspectionRepository.findById(id).orElseThrow(() -> new RuntimeException("inspection not found"));
        inspectionRepository.delete(inspection);
    }


    public Map<String, List<Inspection>> getWeekdayInspections() {
        List<Inspection> inspections = inspectionRepository.groupByDayOfWeek();
        Map<String, List<Inspection>> groupedInspections = new LinkedHashMap<>();

        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getValue() >= DayOfWeek.MONDAY.getValue() && day.getValue() <= DayOfWeek.FRIDAY.getValue()) {
                String dayName = day.getDisplayName(TextStyle.FULL, new Locale("uk", "UA"));
                groupedInspections.put(dayName, new ArrayList<>());
            }
        }

        for (Inspection inspection : inspections) {
            String dayName = inspection.getDateInspection().getDayOfWeek()
                    .getDisplayName(TextStyle.FULL, new Locale("uk", "UA"));
            groupedInspections.get(dayName).add(inspection);
        }

        return groupedInspections;
    }
}
