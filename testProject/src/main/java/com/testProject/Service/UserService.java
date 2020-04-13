package com.testProject.Service;

import com.testProject.models.Acknowledge;
import com.testProject.models.User;
import com.testProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CommanService{

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> addNewUser(User user) {
        if(!validateUser(user))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        userRepository.save(user);
        Acknowledge acknowledge = new Acknowledge(user.getId(), user.getUserName());
        return new ResponseEntity<>(acknowledge,HttpStatus.CREATED);
    }
}
