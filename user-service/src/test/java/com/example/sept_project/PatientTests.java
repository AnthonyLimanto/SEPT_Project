package com.example.sept_project;

import com.example.sept_project.controller.DoctorController;
import com.example.sept_project.controller.PatientController;
import com.example.sept_project.model.Patient;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientTests {

    @Autowired
    private MockMvc mockMvc;
    MvcResult request;
    String content;
    String test_patient_1, test_patient_2;


    // Test Patients added before each @Test
    @BeforeEach
    void setUp() throws Exception {
        test_patient_1 = "{\"id\":1,\"name\":\"Steve Smith\"}";
        test_patient_2 = "{\"id\":2,\"name\":\"Michelle Dalvir\"}";
        // Post both doctors to the endpoint
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/Patient/add")
                        .content(test_patient_1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/Patient/add")
                .content(test_patient_2)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }



    // Request that all patients equal the patients added in @BeforeEach
    @Test
    void getAllPatientsRequest() throws Exception {
        // Expected returned content
        String expected_string = "[" + test_patient_1 + "," + test_patient_2 + "]";
        request = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/Patient/getAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        // Return content in form of string
        content = request.getResponse().getContentAsString();

        // Compare the expected string with content returned
        assertEquals(expected_string, content);
    }


    // Adding a patient to DB
    @Test
    void addPatientRequest() throws Exception {
        final String new_patient = "{\"id\":3,\"name\":\"Joe M'bappe\"}";
        request = this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/Patient/add")
                        .content(new_patient)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        content = request.getResponse().getContentAsString();

        // Check that the patient is equal to the patient added
        assertEquals(new_patient, content);
    }

    // Update a Patient given the patient ID
    @Test
    void updatePatientRequest() throws Exception {
        final String updated_patient = "{\"id\":1,\"name\":\"Steve Tyler\"}";
        request = this.mockMvc.perform(MockMvcRequestBuilders
                        // Get the patient to update
                        .get("/Patient/update/1")
                        .content(updated_patient)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        // Content of the returned request is equal to the updated patient
        content = request.getResponse().getContentAsString();
        assertEquals(updated_patient, content);

    }

    @Test
    void deletePatientRequest() throws Exception {
        request = this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/Patient/delete2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        content = request.getResponse().getContentAsString();
        assertEquals("", content);
    }

    // Delete a Patient given the ID
    @Test
    void getSpecificPatientRequest() throws Exception {
        request = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/Patient/get/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Check that nothing is returned but the request status.isOK()
        content = request.getResponse().getContentAsString();
        assertEquals(test_patient_1, content);
    }



}
