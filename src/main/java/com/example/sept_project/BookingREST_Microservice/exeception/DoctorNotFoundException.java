package com.example.sept_project.BookingREST_Microservice.exeception;

public class DoctorNotFoundException extends RuntimeException{
    private long doctorId;
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
