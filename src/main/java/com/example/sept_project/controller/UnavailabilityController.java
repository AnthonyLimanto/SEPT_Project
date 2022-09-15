package com.example.sept_project.controller;

import com.example.sept_project.model.Unavailability;
import com.example.sept_project.repository.UnavailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnavailabilityController {

    @Autowired
    UnavailabilityRepository unavailabilityRepository;

//    Get all unavailabilities from one doctor
    @GetMapping(path = "/unavailabilities/getAll/{id}")
    public List<Unavailability> getUnavailabilitiesFromDoctor(@PathVariable Long doctor_id){


        return unavailabilityRepository.findAllByDoctor_Id(doctor_id);
    }

    @PostMapping(path = "/unavailabilities/add/")
    public Unavailability addUnavailability(@RequestBody Unavailability unavailability) {
        return unavailabilityRepository.save(unavailability);
    }
}
