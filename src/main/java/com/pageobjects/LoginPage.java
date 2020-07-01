package com.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.core.annotations.Page;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.xpath;

@Page
public class LoginPage extends BasePage {
    @Getter
    private final SelenideElement centerColumn = $x("//*[@id='center_column']");
    @Getter
    private final SelenideElement authenticationTitle = centerColumn.find(xpath("//*[@class='page-heading']"));
    @Getter
    private final SelenideElement emailFld = centerColumn.find(xpath("//*[@id='email']"));
    @Getter
    private final SelenideElement passwordFld = centerColumn.find(xpath("//*[@id='passwd']"));
    @Getter
    private final SelenideElement signInBtn = centerColumn.find(xpath("//*[@id='SubmitLogin']"));
}
