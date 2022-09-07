package com.example.sept_project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")

public class Doctor {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String clinic;

    public Doctor(){
        super();
    }

    public Doctor(Long id, String name, String clinic) {
        this.id = id;
        this.name = name;
        this.clinic = clinic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

}
