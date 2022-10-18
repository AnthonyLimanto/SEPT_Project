package com.example.sept_project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Doctor")

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name can't be blank")
    private String name;

    @NotBlank(message = "Clinic name can't be blank")
    private String clinic;

    @OneToMany (mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany (mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Unavailability> unavailabilities;


    public Doctor(){
    }

    public Doctor(String name, String clinic) {
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Unavailability> getUnavailabilities() {
        return unavailabilities;
    }

    public void setUnavailabilities(List<Unavailability> unavailabilities) {
        this.unavailabilities = unavailabilities;
    }

    public boolean containsUnavailabilities(Date unavailable) {
        boolean found = false;

        for (int i = 0; i < this.unavailabilities.size() && !found; i++) {
            if (this.unavailabilities.get(i).getUnavailable().compareTo(unavailable) == 0) {
                found = true;
            }
        }

        return found;
    }

    public void addUnavailability(Unavailability unavailability) {
        this.unavailabilities.add(unavailability);
    }

}
