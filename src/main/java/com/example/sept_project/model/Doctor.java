package com.example.sept_project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Doctor")

public class Doctor {
    @Id
    @SequenceGenerator( name = "doctor_sequence", sequenceName = "doctor_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "doctor_sequence")
    private Long id;

    private String name;

    private String clinic;

    @OneToMany (mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    @OneToMany (mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Unavailability> unavailabilities;

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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Unavailability> getUnavailabilities() {
        return unavailabilities;
    }

    public void setUnavailability(List<Unavailability> Unavailabilities) {
        this.unavailabilities = Unavailabilities;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

}
