package com.core.webdriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Properties;

public class WebDriverManager implements WebDriverProvider {

    private final Properties props;

    private WebDriverManager() throws IOException {
        props = new Properties();
        props.load(new FileInputStream(this.getClass().getClassLoader()
                .getResource("configs/config.properties").getFile()));
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        var caps = new DesiredCapabilities();
        caps.setBrowserName(System.getProperty("browser"));
        caps.setCapability("enableVNC", Boolean.valueOf(props.getProperty("enableVnc")));
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        try {
            return new RemoteWebDriver(URI.create(props.getProperty("gridUrl")).toURL(), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

