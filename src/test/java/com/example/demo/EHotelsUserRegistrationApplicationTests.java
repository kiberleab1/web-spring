package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.KKHHH.eHotels.userrepositories.UserRepository;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;


@RunWith(SpringRunner.class)
@SpringBootTest

@WebMvcTest
public class EHotelsUserRegistrationApplicationTests {
	
	@Autowired
	MockMvc mockmvc;
	
	@MockBean
	UserRepository userRepository;
	
	
	@Test
	public void contextLoads() throws Exception{
		Mockito.when(userRepository.findAll()).thenReturn(
				Collection.emptyList()
				);
		
		
		MvcResult mvcResult = mockmvc.perform(
				MockMvcRequestBuilders.get("//register/user")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(userRepository).findAll();
	}
}

