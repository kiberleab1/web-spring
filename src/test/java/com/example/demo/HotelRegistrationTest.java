package com.example.demo;

import com.hhhkk.eHotels.EHotelsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
//@WebMvcTest(MainController.class)
@AutoConfigureMockMvc(secure = false)
@ComponentScan({ "com.hhhkk.eHotels.services" })
@ComponentScan({ "com.hhhkk.eHotels.*" })
@EntityScan("com.hhhkk.eHotels.domains")
//@ContextConfiguration(classes = EHotelsApplication.class)
@SpringBootTest(classes = EHotelsApplication.class)
@EnableJpaRepositories(basePackages = "com.hhhkk.eHotels.repositories")
@WebAppConfiguration
@Transactional
public class HotelRegistrationTest {

    @Autowired
        private MockMvc mvc;


        @Test
        public void registerUser() throws Exception{

            mvc.perform(post("/registration").secure(false)
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("hotelName", "capital")
                            .param("city", "addis")
                            .param("subCity", "addis")
                            .param("email", "boss@gmail.com")
                            .param("password", "12345678")
                    // .sessionAttr("todo", new TodoDTO())
            )
                    //.andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/"));

        //.andExpect(model().attribute("id", is("3")))
        // .andExpect(flash().attribute("feedbackMessage", is("Todo entry: title was added.")));

    }
}
