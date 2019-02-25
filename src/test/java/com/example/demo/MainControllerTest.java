package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.hhhkk.eHotels.EHotelsApplication;
import com.hhhkk.eHotels.controllers.MainController;

@RunWith(SpringRunner.class)
//@WebMvcTest(MainController.class)
@AutoConfigureMockMvc
@ComponentScan({ "com.hhhkk.eHotels.services" })
@ComponentScan({ "com.hhhkk.eHotels.*" })
@EntityScan("com.hhhkk.eHotels.domains")
//@ContextConfiguration(classes = EHotelsApplication.class)
@SpringBootTest(classes = EHotelsApplication.class)
@EnableJpaRepositories(basePackages = "com.hhhkk.eHotels.repositories")
@WebAppConfiguration
@Transactional
public class MainControllerTest {
	@Autowired
	// private ApplicationContext applicationContext;
	public MockMvc mockMvc;
	public MainController mainController;

	@Test
	public void testControllerGet() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login"))
				.andExpect(content().string(containsString("Log In")));
	}

	@Test(expected = StackOverflowError.class)
	@WithMockUser(username = "kiberleabeniyew12@gmail.com", password = "12345678")
	public void testAdminLogin() throws Exception {
		mockMvc.perform(formLogin().user("kiberleabeniyew12@gmail.com").password("12345678"))
				.andExpect(redirectedUrl("User/Home")).andExpect(status().isFound()).andExpect(view().name("UserHome"))
				.andExpect(content().string(containsString("Call: +251930856544")));
	}

	@Test(expected = StackOverflowError.class)
	@WithMockUser(username = "meron123", password = "meron123")
	public void testHotelLogin() throws Exception {
		mockMvc.perform(formLogin().user("meron123").password("meron123")).andExpect(status().isOk())
				.andExpect(view().name("registerTeacher")).andExpect(content().string(containsString("Register")));
	}

	@Test(expected = StackOverflowError.class)
	@WithMockUser(username = "abe123", password = "abe12345")
	public void testTeacherLogin() throws Exception {
		mockMvc.perform(formLogin().user("abe123").password("abe12345")).andExpect(status().isOk())
				.andExpect(view().name("uploadPost")).andExpect(content().string(containsString("Post")));
	}

}
