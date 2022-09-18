package com.example.sept_project.exeception;

public class PatientNotFoundException extends RuntimeException {
    private long patientId;
    public PatientNotFoundException(String message) {
        super(message);
    }
}
