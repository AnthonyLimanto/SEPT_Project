package com.example.sept_project.execption;

public class DoctorNotFoundException extends RuntimeException{
    private long doctorId;
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
