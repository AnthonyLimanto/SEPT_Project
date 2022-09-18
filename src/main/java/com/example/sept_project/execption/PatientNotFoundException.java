package com.example.sept_project.execption;

public class PatientNotFoundException extends RuntimeException {
    private long patientId;
    public PatientNotFoundException(String message) {
        super(message);
    }
}
