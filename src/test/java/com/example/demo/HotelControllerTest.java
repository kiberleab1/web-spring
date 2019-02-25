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
import com.hhhkk.eHotels.controllers.HotelController;
import com.hhhkk.eHotels.controllers.HotelListController;

@RunWith(SpringRunner.class)
//@WebMvcTest(HotelController.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan({ "com.hhhkk.eHotels.services" })
@ComponentScan({ "com.hhhkk.eHotels.*" })
@EntityScan("com.hhhkk.eHotels.domains")
//@ContextConfiguration(classes = EHotelsApplication.class)
@SpringBootTest(classes = EHotelsApplication.class)
@EnableJpaRepositories(basePackages = "com.hhhkk.eHotels.repositories")
@WebAppConfiguration
@Transactional
public class HotelControllerTest {

	
	@Autowired
	private MockMvc mockMvc; // <2>
	public HotelController hotelController;
	
	@Test
	@WithMockUser(username = "haile@gmail.com", password = "12345678", roles = "MANAGER")
	public void gethotelController() throws Exception {
		mockMvc.perform(get("/Hotel/profile")).andExpect(status().is3xxRedirection());
				//.andExpect(content().string(containsString("The Ultimate Packing List For Female Travelers")));
	}
	
	
	
	
}
