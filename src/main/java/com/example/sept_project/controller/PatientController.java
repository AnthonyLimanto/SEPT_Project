package com.example.sept_project.controller;

import com.example.sept_project.execption.PatientNotFoundException;
import com.example.sept_project.model.Patient;
import com.example.sept_project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientRepository PatientRepository;
    //  get all notes
    @GetMapping(path = "/Patient/getAll")
    public List<Patient> getAllNotes() {
        return  PatientRepository.findAll();
    }
    //  create patient
    @PostMapping(path = "/Patient/add")
    public Patient createNote(@RequestBody Patient patient) {
        return PatientRepository.save(patient);
    }
    //  get one patient
    @GetMapping( path = "/Patient/get/{id}")
    public Optional<Patient> getNoteById(@PathVariable(value = "id") Long patientId) {

        return PatientRepository.findById(patientId);
    }
    //    update patient
    @GetMapping(path = "/Patient/update/{id}")
    public Patient updateNote(@PathVariable(value = "id") Long patientId, @RequestBody Patient patientDetails) throws PatientNotFoundException {
        Patient patient = PatientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        patient.setName(patientDetails.getName());

        Patient updatedPatient = PatientRepository.save(patient);
        return updatedPatient;
    }

    //    delete patient
    @DeleteMapping(path = "/Patient/delete{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long patientId) throws PatientNotFoundException {
        Patient patient = PatientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(patientId));

        PatientRepository.delete(patient);

        return ResponseEntity.ok().build();
    }
}
