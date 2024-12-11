package com.oop.practice.dto;

import java.time.LocalDate;

public class InspectionDTO {

    private Long id;

    private String nameAttraction;

    private int numberInspetion;

    private LocalDate dateInspection;

    private String typeInspection;

    private String locationAttraction;

    public InspectionDTO() {}

    public InspectionDTO(Long id, String nameAttraction, int numberInspetion, LocalDate dateInspection, String typeInspection, String locationAttraction) {
        this.id = id;
        this.nameAttraction = nameAttraction;
        this.numberInspetion = numberInspetion;
        this.dateInspection = dateInspection;
        this.typeInspection = typeInspection;
        this.locationAttraction = locationAttraction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
