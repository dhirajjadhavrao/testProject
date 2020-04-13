package com.testProject.controller;

import com.testProject.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
@DisplayName("User Controller Test For")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private String userMock;

    @BeforeEach
    void setup(){
        userMock = String.format("{ \"userName\" : \"%s\", \"email\" : \"%s\" }","testUser","user@test.com");
    }


    @Nested
    @DisplayName("Add User With")
    class TestAddUser {
        @Test
        @DisplayName("Valid User Object")
        void addNewUser() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
                                                .content(userMock)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .accept(MediaType.APPLICATION_JSON);

            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andReturn();
        }

        @Test
        @DisplayName("Invalid User Object")
        void addNewUser_InvalidObject() throws Exception{
            userMock = String.format("{ \"userName\" : \"%s\" }","testUser");
            RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(userMock)
                                                    .accept(MediaType.APPLICATION_JSON);

            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andReturn();

        }
    }


}