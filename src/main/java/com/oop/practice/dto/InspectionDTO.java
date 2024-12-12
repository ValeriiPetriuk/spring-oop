package com.oop.practice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class InspectionDTO {

    @NotNull(message = "name attraction cannot be null")
    private String nameAttraction;
    @NotNull(message = "number inspection cannot be null")
    @Min(value = 1, message = "number inspection must be at least 1")
    @Max(value = 5, message = "number inspection must be no more than 5")
    private int numberInspetion;

    @NotNull(message = "date inspection cannot be null")
    private LocalDate dateInspection;

    @NotNull(message = "type inspection cannot be null")
    private String typeInspection;

    @NotNull(message = "location inspection cannot be null")
    private String locationAttraction;

    public InspectionDTO() {}

    public InspectionDTO(String nameAttraction, int numberInspetion, LocalDate dateInspection, String typeInspection, String locationAttraction) {
//        this.id = id;
        this.nameAttraction = nameAttraction;
        this.numberInspetion = numberInspetion;
        this.dateInspection = dateInspection;
        this.typeInspection = typeInspection;
        this.locationAttraction = locationAttraction;
    }



    public String getNameAttraction() {
        return nameAttraction;
    }

    public void setNameAttraction(String nameAttraction) {
        this.nameAttraction = nameAttraction;
    }

    public int getNumberInspetion() {
        return numberInspetion;
    }

    public void setNumberInspetion(int numberInspetion) {
        this.numberInspetion = numberInspetion;
    }

    public LocalDate getDateInspection() {
        return dateInspection;
    }

    public void setDateInspection(LocalDate dateInspection) {
        this.dateInspection = dateInspection;
    }

    public String getTypeInspection() {
        return typeInspection;
    }

    public void setTypeInspection(String typeInspection) {
        this.typeInspection = typeInspection;
    }

    public String getLocationAttraction() {
        return locationAttraction;
    }

    public void setLocationAttraction(String locationAttraction) {
        this.locationAttraction = locationAttraction;
    }
}
