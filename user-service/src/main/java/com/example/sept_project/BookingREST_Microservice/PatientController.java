package com.example.sept_project.BookingREST_Microservice;

import com.example.sept_project.BookingREST_Microservice.model.Patient;
import com.example.sept_project.BookingREST_Microservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody @Valid Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(value = "id") Long patientId) {
        return patientService.getPatient(patientId);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient updatePatient(@PathVariable(value = "id") Long patientId,
                                 @RequestBody @Valid Patient patient) {
        return patientService.updatePatient(patientId, patient);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable(value = "id") Long patientId) {
        patientService.deletePatient(patientId);
    }
}
