package com.epam.pricingcalc.test;

import com.epam.pricingcalc.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractGoogleCloudTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver= DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
        driver=null;
    }
}
