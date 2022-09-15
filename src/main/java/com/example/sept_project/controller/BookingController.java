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
    public Booking createNote(@RequestBody Booking booking) throws BookingNotFoundException {

        //    checks if the booking date is in the specified doctor's unavailabilities
//    Throws exception for now, later I want to just make it, so it tells the patient that they are unable to make a booking on this day
        if (booking.getDoctor().getUnavailabilities().contains(booking.getDate())) {
            System.out.println(booking.getDoctor().getName() + " is unavailable on " + booking.getDate());
            throw new BookingNotFoundException(booking.getId());
        }

        return BookingRepository.save(booking);
    }
    //  get one booking
    @GetMapping( path = "/Booking/get/{id}")
    public Optional<Booking> getNoteById(@PathVariable(value = "id") Long bookingId) throws BookingNotFoundException {
        Booking booking = BookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException(bookingId));

        return BookingRepository.findById(bookingId);
    }
    //    update booking
    @GetMapping(path = "/Booking/update/{id}")
    public Booking updateNote(@PathVariable(value = "id") Long bookingId, @RequestBody Booking bookingDetails) throws BookingNotFoundException {
        Booking booking = BookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));

        booking.setDate(bookingDetails.getDate());
        booking.setDoctor(bookingDetails.getDoctor());

//    checks if the booking date is in the specified doctor's unavailabilities
//    Throws exception for now, later I want to just make it, so it tells the patient that they are unable to make a booking on this day
        if (booking.getDoctor().getUnavailabilities().contains(booking.getDate())) {
            System.out.println(booking.getDoctor().getName() + " is unavailable on " + booking.getDate());
            throw new BookingNotFoundException(bookingId);
        }

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
