package com.example.sept_project.controller;

import com.example.sept_project.execption.BookingNotFoundException;
import com.example.sept_project.model.Booking;
import com.example.sept_project.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingRepository BookingRepository;
    //  get all notes
    @GetMapping(path = "/Booking/getAll")
    public List<Booking> getAllNotes() {
        return  BookingRepository.findAll();
    }
    //  create booking
    @PostMapping(path = "/Booking/add")
    public Booking createNote(@RequestBody Booking booking) {
        return BookingRepository.save(booking);
    }
    //  get one booking
    @GetMapping( path = "/Booking/get/{id}")
    public Optional<Booking> getNoteById(@PathVariable(value = "id") Long bookingId) {

        return BookingRepository.findById(bookingId);
    }
    //    update booking
    @GetMapping(path = "/Booking/update/{id}")
    public Booking updateNote(@PathVariable(value = "id") Long bookingId, @RequestBody Booking bookingDetails) throws BookingNotFoundException {
        Booking booking = BookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));

        booking.setDate(bookingDetails.getDate());

        Booking updatedBooking = BookingRepository.save(booking);
        return updatedBooking;
    }

    //    delete booking
    @DeleteMapping(path = "/Booking/delete{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookingId) throws BookingNotFoundException {
        Booking booking = BookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException(bookingId));

        BookingRepository.delete(booking);

        return ResponseEntity.ok().build();
    }
}
