package com.example.sept_project.BookingREST_Microservice.exeception;

public class BookingNotFoundException extends RuntimeException{
    private long bookingId;
    public BookingNotFoundException(String message) {
        super(message);
    }
}
