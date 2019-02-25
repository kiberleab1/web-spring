package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.hhhkk.eHotels.controllers.MainController;

public class EditReservationTest {
	
	@Autowired
	private MockMvc mockMvc; // <2>
	public MainController mainController;
	@Test
	
	@WithMockUser(username = "test@test.com", password = "12345678",roles={"USER"})
	public void test() throws Exception {
		mockMvc.perform(post("/User/myreservation/edit?reserveId=6")
				.content("arrivaldate=19/01/2019&departuredate=25/01/2019&room=1 "
						+ "room&bedtype=single&guests=1 &note=test")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().is3xxRedirection())
				.andExpect(header().stringValues("Location", "/"));
	}

}
