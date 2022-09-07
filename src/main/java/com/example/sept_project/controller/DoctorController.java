package com.example.sept_project.controller;

import com.example.sept_project.execption.DoctorNotFoundException;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository DoctorRepository;
//  get all notes
    @GetMapping(path = "/Doctor/getAll")
    public List<Doctor> getAllNotes() {
        return  DoctorRepository.findAll();
    }
//  create doctor
    @PostMapping(path = "/Doctor/add")
    public Doctor createNote(@RequestBody Doctor doctor) {
        return DoctorRepository.save(doctor);
    }
//  get one doctor
    @GetMapping( path = "/Doctor/get/{id}")
    public Optional<Doctor> getNoteById(@PathVariable(value = "id") Long doctorId) {

        return DoctorRepository.findById(doctorId);
    }
//    update doctor
    @GetMapping(path = "/Doctor/update/{id}")
    public Doctor updateNote(@PathVariable(value = "id") Long doctorId, @RequestBody Doctor doctorDetails) throws DoctorNotFoundException {
        Doctor doctor = DoctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException(doctorId));

        doctor.setName(doctorDetails.getName());
        doctor.setClinic((doctorDetails.getClinic()));

        Doctor updatedDoctor = DoctorRepository.save(doctor);
        return updatedDoctor;
    }

//    delete doctor
    @DeleteMapping(path = "/Doctor/delete{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long doctorId) throws DoctorNotFoundException {
        Doctor doctor = DoctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        DoctorRepository.delete(doctor);

        return ResponseEntity.ok().build();
    }
}
