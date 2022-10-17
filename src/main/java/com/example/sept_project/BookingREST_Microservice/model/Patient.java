package com.example.sept_project.BookingREST_Microservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name not acceptable")
    private String name;

    @OneToMany (mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    public Patient(){
    }

    public Patient(String name) {
        this.name = name;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBookings(Booking booking) {
        this.bookings.add(booking);
    }


    public void setName(String name) {
        this.name = name;
    }
}
