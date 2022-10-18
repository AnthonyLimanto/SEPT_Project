package com.example.sept_project.controller;

import com.example.sept_project.model.Booking;
import com.example.sept_project.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping(path = "doctor/{doctor_id}/patient/{patient_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody @Valid Booking booking, @PathVariable Long doctor_id, @PathVariable Long patient_id) {
        return bookingService.addBooking(booking, doctor_id, patient_id);
    }


    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Booking getBookingById(@PathVariable(value = "id") Long bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Booking updateBooking(@PathVariable(value = "id") Long bookingId,
                               @RequestBody @Valid Booking updatedBooking) {
        return bookingService.updateBooking(bookingId, updatedBooking);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable(value = "id") Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }
}
