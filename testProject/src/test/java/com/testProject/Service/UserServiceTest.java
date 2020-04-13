package com.testProject.Service;

import com.testProject.models.Acknowledge;
import com.testProject.models.User;
import com.testProject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserService.class)
@RunWith(SpringJUnit4ClassRunner.class)
@DisplayName("UserService test with")
class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMockBean;

    @MockBean
    private CommanService commanServiceMockBean;

    @InjectMocks
    private UserService userServiceInjectMocks;

    private User userMock;

    @BeforeEach
    void setup(){
        userMock = new User("testUser","user@test.com");
    }

    @Test
    @DisplayName("Valid User Object")
    void addNewUser() {
        ResponseEntity<?> responseEntity = userServiceInjectMocks.addNewUser(userMock);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);

        Acknowledge acknowledge = (Acknowledge) responseEntity.getBody();
        assertEquals(userMock.getUserName(), acknowledge.getUserName());
    }
}