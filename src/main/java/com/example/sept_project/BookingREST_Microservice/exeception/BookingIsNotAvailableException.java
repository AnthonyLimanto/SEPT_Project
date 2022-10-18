package com.example.sept_project.BookingREST_Microservice.exeception;

import com.example.sept_project.BookingREST_Microservice.model.Booking;

public class BookingIsNotAvailableException extends RuntimeException{

    private Booking booking;
    public BookingIsNotAvailableException(String message) {
        super(message);
    }
}
