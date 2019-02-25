package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.hhhkk.eHotels.EHotelsApplication;
import com.hhhkk.eHotels.controllers.MyReservationController;

@RunWith(SpringRunner.class)
//@WebMvcTest(MyReservationController.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan({ "com.hhhkk.eHotels.services" })
@ComponentScan({ "com.hhhkk.eHotels.*" })
@EntityScan("com.hhhkk.eHotels.domains")
//@ContextConfiguration(classes = EHotelsApplication.class)
@SpringBootTest(classes = EHotelsApplication.class)
@EnableJpaRepositories(basePackages = "com.hhhkk.eHotels.repositories")
@WebAppConfiguration
@Transactional
public class MyReservationControllerTest {
	@Autowired
	private MockMvc mockMvc; // <2>
	public MyReservationController myreservationController;
	
	@Test
	public void getResrvationCOntroller() throws Exception {
		mockMvc.perform(get("/User/myreservation")).andExpect(status().is3xxRedirection());

				//.andExpect(view().name("myreservation"))
				//.andExpect(content().string(containsString("The Ultimate Packing List For Female\r\n" +
				//		"								Travelers")));
	}
	
	
	 @Test
     public void getRequestsPostTest() throws Exception
	    { 	mockMvc.perform(post("/User/myreservation")
	    		   .content("reserveId=1 & reserveHotel=ShegerHotel &arrivaldate=1/6/2018 & departuredate=1/6/2019 & room=5 & guests=1 bedtype=two")
	    		   .contentType(MediaType.APPLICATION_FORM_URLENCODED))
				   .andExpect(status().is3xxRedirection());
				   //.andExpect(header().stringValues("Location", "/User/myreservation"));
	    }
	 
	 @Test
	public void editReservation() throws Exception {
			mockMvc.perform(get("edit")).andExpect(status().isOk()).andExpect(view().name("booknow"))
					.andExpect(content().string(containsString("Thank You For Booking With US")));
		}
	 
}
