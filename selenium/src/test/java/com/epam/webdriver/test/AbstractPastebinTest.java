package com.epam.webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractPastebinTest {
    protected WebDriver driver;
    private static final String ARGUMENT_START_MAXIMIZED = "--start-maximized";
    private static final String ARGUMENT_REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(ARGUMENT_START_MAXIMIZED);
        chromeOptions.addArguments(ARGUMENT_REMOTE_ALLOW_ORIGINS);
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
