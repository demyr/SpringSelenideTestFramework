package com.api;

import com.core.annotations.Steps;
import com.pojos.user.UserGetDTO;
import com.pojos.user.UserPostDTO;
import com.services.UsersService;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;

@Steps
public class UserSteps {

    @Autowired
    private UsersService service;

    public UserPostDTO getUserInfo(){

        return UserPostDTO.of().setFirstName("fname").setLastName("lname");
    }

    @Step("Create user")
    public UserGetDTO createUser(UserPostDTO userPostDTO){
        return service.postUser(userPostDTO);
    }

    @Step("get user")
    public UserGetDTO getUser(){
        return service.getUser("12");
    }
}
