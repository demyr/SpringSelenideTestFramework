package com.ui.steps;

import com.core.annotations.Steps;
import com.pageobjects.MainPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.visible;

@Steps
public class MainPageSteps extends BaseUISteps {

    @Autowired
    MainPage mainPage;

    @Step("User clicks sign in button")
    public void userClicksSignInButton() {
        mainPage.getSignInButton().click();
    }

    @Step("User clicks sign out button")
    public void userClicksSignOutButton() {
        mainPage.getSignOutButton().click();
    }


    @Step("User should see main logo")
    public void userShouldSeeMainLogo() {
        mainPage.getLogo().shouldBe(visible);
    }

    @Step("User should see sign in button")
    public void userShouldSeeSignInButton() {
        mainPage.getSignInButton().shouldBe(visible);
    }
}
