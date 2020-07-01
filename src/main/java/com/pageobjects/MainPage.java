package com.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.core.annotations.Page;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Page
public class MainPage extends BasePage {
    @Getter
    private final SelenideElement logo = $x("//*[@class='logo img-responsive']");
    @Getter
    private final SelenideElement signInButton = $x("//*[@class='login']");
    @Getter
    private final SelenideElement signOutButton = $x("//*[@class='logout']");
}
