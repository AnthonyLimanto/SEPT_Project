package com.example.sept_project.controller;

import com.example.sept_project.model.Unavailability;
import com.example.sept_project.service.UnavailabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/unavailabilities")
public class UnavailabilityController {

    UnavailabilityService unavailabilityService;
    public UnavailabilityController(UnavailabilityService unavailabilityService) {
        this.unavailabilityService = unavailabilityService;
    }

    @GetMapping(path = "/{doctor_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Unavailability> getUnavailabilitiesFromDoctor(@PathVariable Long doctor_id){
        return unavailabilityService.getUnavailabilitiesByDoctorId(doctor_id);
    }

    @PostMapping(path = "/doctor/{doctor_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Unavailability createUnavailability(@RequestBody @Valid Unavailability unavailability, @PathVariable Long doctor_id) {
        return unavailabilityService.addUnavailability(unavailability, doctor_id);
    }

//    @PutMapping(path = "/unavailabilities/add/{doctor_id}")
//    public Unavailability addUnavailability(@PathVariable Long doctor_id, @RequestBody Unavailability unavailability)  throws DoctorNotFoundException {
//        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow(() -> new DoctorNotFoundException("doctor_id"));
//        doctor.addUnavailability(unavailability);
//        unavailability.setDoctor(doctor);
//
//        return unavailabilityRepository.save(unavailability);
//    }
}
