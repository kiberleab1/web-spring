package com.example.demo;

import com.hhhkk.eHotels.EHotelsApplication;
import com.hhhkk.eHotels.configurations.SecurityConfiguration;
import com.hhhkk.eHotels.controllers.MainController;
import com.hhhkk.eHotels.controllers.RegistrationController;
import com.hhhkk.eHotels.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Filter;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thymeleaf.context.WebContext;

import javax.transaction.Transactional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void registerUser() throws Exception{

        mvc.perform(post("/register/user").secure(false)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "abc")
                .param("lastName", "cde")
                .param("middleName", "fgh")
                .param("email", "abc@gmail.com")
                .param("password", "12345678")
                .param("idno", "05")
                .param("city", "addis")
                .param("subCity", "addis")
                .param("state", "addis")
                .param("accno", "12345678")
               // .sessionAttr("todo", new TodoDTO())
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/login"));

                //.andExpect(model().attribute("id", is("3")))
               // .andExpect(flash().attribute("feedbackMessage", is("Todo entry: title was added.")));

    }
}
