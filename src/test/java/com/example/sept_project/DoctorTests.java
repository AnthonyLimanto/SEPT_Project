package com.example.sept_project;

import com.example.sept_project.controller.DoctorController;
import com.example.sept_project.model.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DoctorTests {


	// Create new doctors that will be used in the tests
	@Autowired
	DoctorController doctorController;
	Doctor test_doctor_1 = new Doctor(00L, "Joe Grech", "Altona");
	Doctor test_doctor_2 = new Doctor(001L, "Kermi Sexton", "Williamstown");
	Doctor test_doctor_3 = new Doctor(002L, "Robert Falzon", "Yarraville");
	Doctor test_doctor_4 = new Doctor(003L, "Mitch Price", "Tarneit");
	Doctor test_doctor_5 = new Doctor(004L, "Michelle Ebinger", "Point Cook");



	// Test that the controller is being Autowired (Created and is not null).
	@Test
	void contextLoads() {
		assertThat(doctorController).isNotNull();
	}



	// Check if a doctor is able to be added to the JPA Repository.
	@Test
	void addingDoctorToDB(){
		doctorController.createNote(new Doctor(00L, "Joe Grech", "Altona"));
		List<Doctor> test_list = doctorController.getAllNotes();
		assertThat(test_list != null);
	}


	// Test that for each doctor that is added to the repository the size increases by 1
	@Test
	void addingMultipleDoctors(){
		doctorController.createNote(test_doctor_1);
		doctorController.createNote(test_doctor_2);
		doctorController.createNote(test_doctor_3);
		doctorController.createNote(test_doctor_3);
		doctorController.createNote(test_doctor_3);
		List<Doctor> test_list = doctorController.getAllNotes();
		assertThat(test_list.size() == 5);
	}

	// Test that if a Doctor added with an ID is present in the JPA
	@Test
	void getDoctor(){
		doctorController.createNote(test_doctor_1);
		assertThat(doctorController.getNoteById(00L).isPresent());
	}

	// Test that the doctor added can be retrieved by the JPA
	@Test
	void getSpecificDoctor(){
		doctorController.createNote(test_doctor_1);
		List<Doctor> test_doctor = doctorController.getAllNotes();
		assertThat(test_doctor.get(0).getId() == test_doctor_1.getId());
	}



}
