package com.example.sept_project.execption;

public class BookingNotFoundException extends Exception{
    private long bookingId;
    public BookingNotFoundException(long bookingId) {
        super(String.format("Booking not found with id : '%s'", bookingId));
    }
}
