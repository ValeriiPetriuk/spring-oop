//package com.oop.practice.entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name="inspections")
//public class Inspection {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String nameAttraction;
//
//    private int numberInspetion;
//
//    private LocalDate dateInspection;
//
//    private String typeInspection;
//
//    private String locationAttraction;
//
//    public Inspection() {}
//
//    public Inspection(String nameAttraction, int numberInspetion, LocalDate dateInspection, String typeInspection, String locationAttraction) {
//        this.nameAttraction = nameAttraction;
//        this.numberInspetion = numberInspetion;
//        this.dateInspection = dateInspection;
//        this.typeInspection = typeInspection;
//        this.locationAttraction = locationAttraction;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNameAttraction() {
//        return nameAttraction;
//    }
//
//    public void setNameAttraction(String nameAttraction) {
//        this.nameAttraction = nameAttraction;
//    }
//
//    public int getNumberInspetion() {
//        return numberInspetion;
//    }
//
//    public void setNumberInspetion(int numberInspetion) {
//        this.numberInspetion = numberInspetion;
//    }
//
//    public LocalDate getDateInspection() {
//        return dateInspection;
//    }
//
//    public void setDateInspection(LocalDate dateInspection) {
//        this.dateInspection = dateInspection;
//    }
//
//    public String getTypeInspection() {
//        return typeInspection;
//    }
//
//    public void setTypeInspection(String typeInspection) {
//        this.typeInspection = typeInspection;
//    }
//
//    public String getLocationAttraction() {
//        return locationAttraction;
//    }
//
//    public void setLocationAttraction(String locationAttraction) {
//        this.locationAttraction = locationAttraction;
//    }
//
//    @Override
//    public String toString() {
//        return "Inspection{" +
//                "id=" + id +
//                ", nameAttraction='" + nameAttraction + '\'' +
//                ", numberInspetion=" + numberInspetion +
//                ", dateInspection=" + dateInspection +
//                ", typeInspection='" + typeInspection + '\'' +
//                ", locationAttraction='" + locationAttraction + '\'' +
//                '}';
//    }
//}


package com.oop.practice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="inspections")
public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_attraction")
    private String nameAttraction;
    @Column(name = "number_inspection")
    private int numberInspetion;
    @Column(name = "date_inspection")
    private LocalDate dateInspection;
    @Column(name = "type_inspection")
    private String typeInspection;
    @Column(name = "location_attraction")
    private String locationAttraction;

    public Inspection() {}

    public Inspection(String nameAttraction, int numberInspetion, LocalDate dateInspection, String typeInspection, String locationAttraction) {
        this.nameAttraction = nameAttraction;
        this.numberInspetion = numberInspetion;
        this.dateInspection = dateInspection;
        this.typeInspection = typeInspection;
        this.locationAttraction = locationAttraction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Inspection{" +
                "id=" + id +
                ", nameAttraction='" + nameAttraction + '\'' +
                ", numberInspetion=" + numberInspetion +
                ", dateInspection=" + dateInspection +
                ", typeInspection='" + typeInspection + '\'' +
                ", locationAttraction='" + locationAttraction + '\'' +
                '}';
    }
}
