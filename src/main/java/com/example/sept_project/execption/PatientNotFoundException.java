package com.example.sept_project.execption;

public class PatientNotFoundException extends Exception{
    private long patientId;
    public PatientNotFoundException(long patientId) {
        super(String.format("Patient not found with id : '%s'", patientId));
    }
}
