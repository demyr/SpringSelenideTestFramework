package com.ui.steps;

import com.core.annotations.Steps;
import com.pageobjects.LoginPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.text;

@Steps
public class LoginPageSteps extends BaseUISteps {

    @Autowired
    LoginPage page;

    @Step("User should see login page")
    public void userShouldSeeLoginPage() {
        page.getAuthenticationTitle().shouldHave(text("AUTHENTICATION"));
    }

    @Step("User sets '{userName}' user name")
    public void userSetsEmail(String userName) {
        page.getEmailFld().setValue(userName);
    }

    @Step("User sets '{password}' password")
    public void userSetsPassword(String password) {
        page.getPasswordFld().setValue(password);
    }

    @Step("User clicks login button")
    public void userClicksLoginBtn() {
        page.getSignInBtn().click();
    }

    @Step("User '{userName}' enters the application")
    public void userLogsInTheApplicationWith(String email, String password) {
        userSetsEmail(email);
        userSetsPassword(password);
        userClicksLoginBtn();
    }
}
