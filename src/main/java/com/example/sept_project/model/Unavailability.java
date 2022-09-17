package com.example.sept_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Unavailability")
public class Unavailability {
//    Placeholder for now, want to make unavailable and doctor into composite key
    @Id
    @SequenceGenerator( name = "unavailability_sequence", sequenceName = "unavailability_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "unavailability_sequence")
    private Long id;

    private Date unavailable;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Unavailability(Long id, Date unavailable, Doctor doctor) {
        this.id = id;
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
}
