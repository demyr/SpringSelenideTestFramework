package com.ui.steps;

import com.core.annotations.Steps;
import com.pageobjects.UserAccountPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.text;

@Steps
public class UserAccountPageSteps extends BaseUISteps {

    @Autowired
    UserAccountPage myAccountPage;

    @Step("User should see his account")
    public void userShouldSeeHisAccount() {
        myAccountPage.getAccountTitle().shouldHave(text("MY ACCOUNT"));
    }
}
