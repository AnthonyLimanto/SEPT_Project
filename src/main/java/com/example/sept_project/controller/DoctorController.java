package com.example.sept_project.controller;

import com.example.sept_project.execption.DoctorNotFoundException;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
//  get all notes
    @GetMapping("/Doctor")
    public List<Doctor> getAllNotes() {
        return  doctorRepository.findAll();
    }
//  create doctor
    @PostMapping("/Doctor")
    public Doctor createNote(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
//  get one doctor
    @GetMapping("/Doctor/{id}")
    public Optional<Doctor> getNoteById(@PathVariable(value = "id") Long doctorId) {

        return doctorRepository.findById(doctorId);
    }
//    update doctor
    @GetMapping("/Doctor/{id}")
    public Doctor updateNote(@PathVariable(value = "id") Long doctorId, @RequestBody Doctor doctorDetails) throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException(doctorId));

        doctor.setName(doctorDetails.getName());
        doctor.setClinic((doctorDetails.getClinic()));

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return updatedDoctor;
    }

//    delete doctor
    @DeleteMapping("/Doctor/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long doctorId) throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        doctorRepository.delete(doctor);

        return ResponseEntity.ok().build();
    }
}
