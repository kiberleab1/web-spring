package com.example.demo;

import com.hhhkk.eHotels.controllers.ContactController;
import com.hhhkk.eHotels.controllers.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserController.class)
@AutoConfigureMockMvc(secure = false)
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testUser() throws Exception{

        mvc
                .perform(get("/User/Home"))
                .andExpect(status().isOk())
                .andExpect(view().name("UserHome"));

    }
}
