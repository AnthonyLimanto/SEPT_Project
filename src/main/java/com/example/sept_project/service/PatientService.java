package com.example.sept_project.service;

import com.example.sept_project.exeception.PatientNotFoundException;
import com.example.sept_project.model.Patient;
import com.example.sept_project.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatient(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow(() ->
                new PatientNotFoundException(
                        String.format("Patient not found with id: %s", patientId)
                )
        );
    }

    public Patient updatePatient(Long patientId, Patient patient) {
        return patientRepository.findById(patientId).map(curPatient -> {
            curPatient.setName(patient.getName());
            return patientRepository.save(curPatient);
        }).orElseGet(() -> addPatient(patient));
    }

    public void deletePatient(Long patientId) {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
        } else {
            throw new PatientNotFoundException(
                    String.format("Can't delete patient with id: %s, patient does not exist",
                            patientId));
        }
    }
}
