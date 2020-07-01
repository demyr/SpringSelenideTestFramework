package com;

import com.codeborne.selenide.Configuration;
import com.ui.steps.LoginPageSteps;
import com.ui.steps.MainPageSteps;
import com.ui.steps.UserAccountPageSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseUITest extends AbstractTestNGSpringContextTests {
    public final String UI_APP_URL = "http://automationpractice.com/";
    public final String UI_APP_LOGOUT_LINK = "index.php?mylogout=";

    @Autowired
    public LoginPageSteps loginPageSteps;

    @Autowired
    public MainPageSteps mainPageSteps;

    @Autowired
    public UserAccountPageSteps userAccountPageSteps;

    @BeforeSuite(alwaysRun = true)
    protected void setupUIConfigs() {
        Configuration.browser = "com.core.webdriver.WebDriverManager";
        Configuration.startMaximized = true;
        Configuration.screenshots = false;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUpUi() {
        close();
    }
}
