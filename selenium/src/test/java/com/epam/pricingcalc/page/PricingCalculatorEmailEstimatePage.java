package com.epam.pricingcalc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorEmailEstimatePage extends AbstractPage{

    @FindBy(xpath = "//iframe[@src='https://cloud.google.com/frame/products/calculator/index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0.frame?hl=ru']")
    private WebElement firstFrame;
    @FindBy(id = "myFrame")
    private WebElement secondFrame;
    @FindBy(xpath="//input[@ng-model='emailQuote.user.email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    protected PricingCalculatorEmailEstimatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected PricingCalculatorEmailEstimatePage openPage() {
        throw new RuntimeException("You can not open this page. It can be only a result of actions on other page.");
    }

    public PricingCalculatorEmailEstimatePage pasteEmail(String email) {
        goIntoFrames();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        driver.switchTo().defaultContent();
        return this;
    }

    public PricingCalculatorEmailEstimatePage clickSendEmail() {
        goIntoFrames();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        driver.switchTo().defaultContent();
        return this;
    }

    private void goIntoFrames() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstFrame));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(secondFrame));
    }
}
