package com.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.core.annotations.Page;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.xpath;

@Page
public class UserAccountPage {
    @Getter
    private final SelenideElement centerColumn = $x("//*[@id='center_column']");
    @Getter
    private final SelenideElement accountTitle = centerColumn.find(xpath("//*[@class='page-heading']"));
}
