package com.api;

import com.TestSetup;
import io.qameta.allure.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;



@Feature("Users test")
public class UserTest extends TestSetup {

    @Autowired
    private UserSteps userSteps;

    @Test
    public void someTest(){
        var userInfo = userSteps.getUserInfo();
        var createdUser = userSteps.getUser();
        System.out.println(createdUser);
    }
}
