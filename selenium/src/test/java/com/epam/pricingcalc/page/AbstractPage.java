package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract AbstractPage openPage();

    protected void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected boolean isAttributeAriaCheckedEqualsTrue(WebElement checkbox) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(checkbox));
        return Boolean.parseBoolean(checkbox.getAttribute("aria-checked"));
    }

    protected void sendKeysToInput(WebElement input, String keys) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(keys);
    }

    protected void sendKeysToInput(WebElement input, Keys keys) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(keys);
    }

    protected String receiveTextFromWebElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }
}
