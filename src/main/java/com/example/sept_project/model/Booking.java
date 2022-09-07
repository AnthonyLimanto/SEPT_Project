package com.example.sept_project.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Doctor doctor;

    private Date date;

    public Booking(){
        super();
    }

    public Booking(Long id, Doctor doctor, Patient patient, Date date) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
