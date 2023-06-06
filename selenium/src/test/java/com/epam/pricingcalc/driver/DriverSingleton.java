package com.epam.pricingcalc.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    driver = WebDriverManager.firefoxdriver().create();
                    driver.manage().window().maximize();
                }
                default: {
                    driver = WebDriverManager.chromedriver().create();
                    driver.manage().window().maximize();
                }
            }
        }
        return driver;
    }

    public static void switchToOtherTabIfExists() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String currentWindow = driver.getWindowHandle();
        if (tabs.size() > 1) {
            tabs.remove(currentWindow);
            driver.switchTo().window(tabs.get(0));
        }
    }

    public static void createAnotherTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
