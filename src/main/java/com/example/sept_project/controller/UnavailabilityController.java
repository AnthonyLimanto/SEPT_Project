package com.example.sept_project.controller;

import com.example.sept_project.execption.DoctorNotFoundException;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.model.Unavailability;
import com.example.sept_project.repository.DoctorRepository;
import com.example.sept_project.repository.UnavailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnavailabilityController {

    @Autowired
    UnavailabilityRepository unavailabilityRepository;

    @Autowired
    DoctorRepository doctorRepository;

//    Get all unavailabilities from one doctor
    @GetMapping(path = "/unavailabilities/getAll/{doctor_id}", produces = "application/json")
    public List<Unavailability> getUnavailabilitiesFromDoctor(@PathVariable Long doctor_id){


        return unavailabilityRepository.findAllByDoctor_Id(doctor_id);
    }

    @PutMapping(path = "/unavailabilities/add/{doctor_id}")
    public Unavailability addUnavailability(@PathVariable Long doctor_id, @RequestBody Unavailability unavailability)  throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow(() -> new DoctorNotFoundException(doctor_id));
        doctor.addUnavailability(unavailability);
        unavailability.setDoctor(doctor);

        return unavailabilityRepository.save(unavailability);
    }
}
