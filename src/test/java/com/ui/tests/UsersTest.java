package com.ui.tests;

import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Component
public class UsersTest extends BaseUITest {

    @Test(description = "User should be able to login and then logout via UI logout button")
    void UserShouldBeAbleToLogInAndLogOutViaUI() {
        open(UI_APP_URL);
        mainPageSteps.userShouldSeeMainLogo();
        mainPageSteps.userClicksSignInButton();
        loginPageSteps.userLogsInTheApplicationWith("weirdmail@gmail.com", "12345678");
        userAccountPageSteps.userShouldSeeHisAccount();
        mainPageSteps.userClicksSignOutButton();
        loginPageSteps.userShouldSeeLoginPage();
    }

    @Test(description = "User should be able to login and then logout via link")
    void UserShouldBeAbleToLogInAndLogOutViaLink() {
        open(UI_APP_URL);
        mainPageSteps.userShouldSeeMainLogo();
        mainPageSteps.userClicksSignInButton();
        loginPageSteps.userLogsInTheApplicationWith("weirdmail@gmail.com", "12345678");
        userAccountPageSteps.userShouldSeeHisAccount();
        open(UI_APP_URL + UI_APP_LOGOUT_LINK);
        mainPageSteps.userShouldSeeSignInButton();
    }
}
