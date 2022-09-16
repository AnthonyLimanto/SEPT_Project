package com.example.sept_project;

import com.example.sept_project.controller.DoctorController;
import com.example.sept_project.controller.PatientController;
import com.example.sept_project.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientTests {

    @Autowired
    PatientController patientController;

    Patient test_patient_1 = new Patient(00L, "Jeremy Smith");
    Patient test_patient_2 = new Patient(01L, "Leobwin Janine");
    Patient test_patient_3 = new Patient(02L, "Heber Beorhtsige");
    Patient test_patient_4 = new Patient(03L, "Theodoric Tamara");
    Patient test_patient_5 = new Patient(04L, "Sigfrøðr Pemphero");



    @Test
    void contextLoads() {
        assertThat(patientController).isNotNull();
    }



}
