package com.example.sept_project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.*;

public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private Doctor doctor;

    private Date date;

    public Booking(){
        super();
    }

    public Booking(Long id, Doctor doctor, Date date) {
        this.id = id;
        this.doctor = doctor;
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
