package com.example.sept_project;

import com.example.sept_project.controller.BookingController;
import com.example.sept_project.controller.PatientController;
import com.example.sept_project.model.Booking;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookingTests {
    @Autowired
    BookingController bookingController;

    Doctor test_doctor_1 = new Doctor(00L, "George Smith", "Altona");
    Patient test_patient_1 = new Patient(01L, "Fiona Scott");
    Booking test_booking_1 = new Booking(100L, test_doctor_1, test_patient_1, new Date());

    @Test
    void contextLoads() {
        assertThat(bookingController).isNotNull();
    }
}
