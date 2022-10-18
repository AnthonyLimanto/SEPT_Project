package com.example.sept_project.controller;

import com.example.sept_project.model.Doctor;
import com.example.sept_project.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createDoctor(@RequestBody @Valid Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctorById(@PathVariable(value = "id") Long doctorId) {
        return doctorService.getDoctor(doctorId);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor updateDoctor(@PathVariable(value = "id") Long doctorId,
                                 @RequestBody @Valid Doctor doctor) {
        return doctorService.updateDoctor(doctorId, doctor);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable(value = "id") Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }



//    @PutMapping (path = "/Doctor/{id}/addUnavailable")
//    public Doctor addUnavailable(@PathVariable(value = "id") Long doctorId, @RequestBody Unavailability unavailability) throws DoctorNotFoundException {
//        Doctor doctor = DoctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException(doctorId));
//
//        List<Unavailability> newUnava = doctor.getUnavailabilities();
//        newUnava.add(unavailability);
//        doctor.setUnavailabilities(newUnava);
//
//        Doctor updatedDoctor = DoctorRepository.save(doctor);
//        return updatedDoctor;
//    }

}
