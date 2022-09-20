package com.example.sept_project;

import com.example.sept_project.controller.DoctorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DoctorTests {


	// Create new doctors that will be used in the tests


	@Autowired
	private MockMvc mockMvc;
	MvcResult request;
	String content;
	String test_doctor_1, test_doctor_2;


	@Autowired
	private DoctorController test_controller;

	// Intializes test doctors in the form of JSON.
	@BeforeEach
	void setUp() throws Exception {
		test_doctor_1 = "{\"id\":1,\"name\":\"Jeremy Long\",\"clinic\":\"Altona medical\"}";
		test_doctor_2 = "{\"id\":2,\"name\":\"Saral Rohit\",\"clinic\":\"Williams Landing\"}";

		// Add the doctors to the JPA
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/Doctor/add")
				.content(test_doctor_1)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/Doctor/add")
				.content(test_doctor_2)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
	}

	@Test
	void getAllDoctorsRequest() throws Exception {
		// Expect both doctors to be returned
		String expected_string = "[" + test_doctor_1 + "," + test_doctor_2 + "]";

		// Perform a get all request from the endpoint
		request = this.mockMvc.perform(MockMvcRequestBuilders
						.get("/Doctor/getAll")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				// Return the content of the request
				.andReturn();

		// Get the raw JSON of what is returned
		content = request.getResponse().getContentAsString();
		assertEquals(expected_string, content);
	}




	// Check if a doctor is able to be added to the JPA Repository.
	@Test
	void addingDoctorToDBRequest() throws Exception {
		// New doctor to add
		final String new_Doctor = "{\"id\":3,\"name\":\"George Big\",\"clinic\":\"Yarraville\"}";
		request = this.mockMvc.perform(MockMvcRequestBuilders
				// Post request on the endpoint
				.post("/Doctor/add")
				.content(new_Doctor)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		content = request.getResponse().getContentAsString();

		// Assert that the returned doctor is the new doctor
		assertEquals(content, new_Doctor);
	}



	@Test
	void deleteDoctorRequest() throws Exception {
		request = this.mockMvc.perform(MockMvcRequestBuilders
				// Delete request on the mock
					.delete("/Doctor/delete2")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn();
		content = request.getResponse().getContentAsString();
		// Assert that the request has gone through and nothing is displayed
		assertEquals("", content);
	}

	@Test
	void getSpecificDoctorRequest() throws Exception {
		// Request a get that returns a specific doctor
		request = this.mockMvc.perform(MockMvcRequestBuilders
						.get("/Doctor/get/1")
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
				.andReturn();
		content = request.getResponse().getContentAsString();

		// Expect that the content returned is the test_doctor_1 added in @beforeEach setup()
		assertEquals(test_doctor_1,content);
	}

	@Test
	void updateDoctorRequest() throws Exception {
		// doctor to update @RequestBody
		final String update_title = "{\"id\":1,\"name\":\"Jase Gomez\",\"clinic\":\"Tarneit Medical\"}";
		request = this.mockMvc.perform(MockMvcRequestBuilders
						.get("/Doctor/update/1")
						.content(update_title)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
				.andReturn();
		content = request.getResponse().getContentAsString();
		// Assert that the doctor updated is equal to the doctor json string given
		assertEquals(update_title,content);
	}





}
