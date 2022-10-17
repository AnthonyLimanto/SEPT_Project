package com.example.sept_project.exeception;

import com.example.sept_project.model.Booking;

public class BookingIsNotAvailableException extends RuntimeException{

    private Booking booking;
    public BookingIsNotAvailableException(String message) {
        super(message);
    }
}
