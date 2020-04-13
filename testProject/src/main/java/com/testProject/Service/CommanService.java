package com.testProject.Service;

import com.testProject.models.User;

public class CommanService {

    public boolean validateUser(User user){

        return (user.getEmail() != null && user.getUserName() != null);
    }
}
