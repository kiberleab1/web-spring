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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.hhhkk.eHotels.EHotelsApplication;
import com.hhhkk.eHotels.controllers.HotelListController;
import com.hhhkk.eHotels.controllers.MyReservationController;

@RunWith(SpringRunner.class)
//@WebMvcTest(HotelListController.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan({ "com.hhhkk.eHotels.services" })
@ComponentScan({ "com.hhhkk.eHotels.*" })
@EntityScan("com.hhhkk.eHotels.domains")
//@ContextConfiguration(classes = EHotelsApplication.class)
@SpringBootTest(classes = EHotelsApplication.class)
@EnableJpaRepositories(basePackages = "com.hhhkk.eHotels.repositories")
@WebAppConfiguration
@Transactional
public class HotelListControllerTest {

	
	@Autowired
	private MockMvc mockMvc; // <2>
	public HotelListController hotelListController;
	
	@Test
	@WithMockUser(username = "first@gmail.com", password = "12345678", roles = "USER")
	public void gethotelListController() throws Exception {
		mockMvc.perform(get("/User/ViewHotels")).andExpect(status().is3xxRedirection());

				//.andExpect(view().name("Hotels"))
				//.andExpect(content().string(containsString("Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia\r\n" +
				//		"						reprehenderit. Eos cumque dicta adipisci architecto culpa amet.")));
	}
	
	
	 @Test
	 @WithMockUser(username = "first@gmail.com", password = "12345678", roles = "USER")
	 public void getRequestsPostTest() throws Exception
	    {
	    	 mockMvc.perform(post("/User/ViewHotels")
	    		   .contentType(MediaType.APPLICATION_FORM_URLENCODED))
				   .andExpect(status().is3xxRedirection());
				 //  .andExpect(header().stringValues("Location", "HotelList"));
	    }
	 
	
}
