package com.example.sept_project.service;

import com.example.sept_project.exeception.BookingIsNotAvailableException;
import com.example.sept_project.exeception.BookingNotFoundException;
import com.example.sept_project.exeception.DoctorNotFoundException;
import com.example.sept_project.exeception.PatientNotFoundException;
import com.example.sept_project.model.Booking;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.model.Patient;
import com.example.sept_project.repository.BookingRepository;
import com.example.sept_project.repository.DoctorRepository;
import com.example.sept_project.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public BookingService(BookingRepository bookingRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.bookingRepository = bookingRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking addBooking(Booking booking, Long doctor_id, Long patient_id) {
        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor not found with id: %s", doctor_id)));
        Patient patient = patientRepository.findById(patient_id).orElseThrow(() -> new PatientNotFoundException(String.format("Patient not found with id: %s", patient_id)));

        booking.setDoctor(doctor);
        booking.setPatient(patient);

        if (doctor.containsUnavailabilities(booking.getDate())) {
            throw new BookingIsNotAvailableException(String.format("%s is unavailable on %s", booking.getDoctor().getName(), booking.getDate().toString()));
        }

        return bookingRepository.save(booking);
    }

    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(() ->
                new BookingNotFoundException(
                        String.format("Booking not found with id: %s", bookingId)
                )
        );
    }

    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        return bookingRepository.findById(bookingId).map(curBooking -> {
            if (curBooking.getDoctor().containsUnavailabilities((updatedBooking.getDate()))) {
                throw new BookingIsNotAvailableException(String.format("%s is unavailable on %s", curBooking.getDoctor().getName(), updatedBooking.getDate().toString()));
            }
            curBooking.setDate(updatedBooking.getDate());
            return bookingRepository.save(curBooking);
        }).orElseThrow(() -> new BookingNotFoundException(
                String.format("Booking not found with id: %s", bookingId))
        );
    }

    public void deleteBooking(Long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new BookingNotFoundException(
                    String.format("Can't delete booking with id: %s, booking does not exist",
                            bookingId));
        }
    }
}
