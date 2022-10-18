package com.example.sept_project;

import com.example.sept_project.controller.BookingController;
import com.example.sept_project.controller.PatientController;
import com.example.sept_project.model.Booking;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.print.Book;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingTests {
    @Autowired
    private MockMvc mockMvc;
    MvcResult request;
    String content;
    String test_doctor_1, test_doctor_2, test_patient_1, test_patient_2;



    // Intializes test doctors in the form of JSON.
    @BeforeEach
    void setUp() throws Exception {
        test_doctor_1 = "{\"id\":1,\"name\":\"Jeremy Long\",\"clinic\":\"Altona medical\"}";
        test_doctor_2 = "{\"id\":2,\"name\":\"Saral Rohit\",\"clinic\":\"Williams Landing\"}";

        // Add the doctors to the JPA
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/doctor")
                .content(test_doctor_1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/doctor")
                .content(test_doctor_2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        test_patient_1 = "{\"id\":1,\"name\":\"Steve Smith\"}";
        test_patient_2 = "{\"id\":2,\"name\":\"Michelle Dalvir\"}";
        // Post both doctors to the endpoint
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/patient")
                .content(test_patient_1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/patient")
                .content(test_patient_2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

    }


}
