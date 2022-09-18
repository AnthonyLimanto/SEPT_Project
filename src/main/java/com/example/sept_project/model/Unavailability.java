package com.example.sept_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Unavailability")
public class Unavailability {
//    Placeholder for now, want to make unavailable and doctor into composite key
    @Id
    @GeneratedValue
    private Long id;

    private Date unavailable;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Unavailability(Date unavailable, Doctor doctor) {
        this.unavailable = unavailable;
        this.doctor = doctor;
    }


    public Unavailability() {

    }

    public Date getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Date unavailable) {
        this.unavailable = unavailable;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
