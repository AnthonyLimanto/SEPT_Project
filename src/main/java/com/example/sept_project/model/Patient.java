package com.example.sept_project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @SequenceGenerator( name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;

    private String name;

    @OneToMany (mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    public Patient(){
        super();
    }


    public Patient(Long id, String name) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }
}
