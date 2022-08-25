package com.example.sept_project.execption;

public class DoctorNotFoundException extends Exception{
    private long doctorId;
    public DoctorNotFoundException(long doctorId) {
        super(String.format("Doctor not found with id : '%s'", doctorId));
    }
}
