package com;

import com.codeborne.selenide.testng.BrowserPerTest;
import com.core.listeners.BaseListener;
import io.qameta.allure.Issue;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;
import java.util.Arrays;


@Configuration

@EnableFeignClients
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class, HttpMessageConvertersAutoConfiguration.class})
@Listeners({BrowserPerTest.class, BaseListener.class})
@ContextConfiguration("classpath:spring.xml")
public abstract class TestSetup extends AbstractTestNGSpringContextTests {

    @BeforeMethod(alwaysRun = true)
    public void testSetUp(ITestContext context, Method method) {
        if (!method.isAnnotationPresent(Issue.class)) {
            Arrays.stream(context.getAllTestMethods()).forEach(testMethod -> testMethod.setRetryAnalyzerClass(BaseListener.class));
        }
    }
}
