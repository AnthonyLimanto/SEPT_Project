package com.example.sept_project.execption;

import com.example.sept_project.model.Booking;

public class BookingIsNotAvailableException extends Exception{

    private Booking booking;
    public BookingIsNotAvailableException(Booking booking) {
        super(String.format(booking.getDoctor().getName() + " is unavailable on " + booking.getDate()));
    }
}
