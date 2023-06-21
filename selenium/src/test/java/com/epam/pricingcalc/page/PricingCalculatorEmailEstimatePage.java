package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorEmailEstimatePage extends AbstractPage{
    private static final Logger logger = LogManager.getLogger();
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
        logger.error("You can not open this page. It can be only a result of actions on other page.");
        throw new RuntimeException("You can not open this page. It can be only a result of actions on other page.");
    }

    public PricingCalculatorEmailEstimatePage pasteEmail(String email) {
        logger.debug("Trying to paste email address.");
        goIntoFrames();
        sendKeysToInput(emailInput, email);
        driver.switchTo().defaultContent();
        return this;
    }

    public PricingCalculatorEmailEstimatePage clickSendEmail() {
        logger.debug("trying to click button 'Send email'.");
        goIntoFrames();
        click(sendEmailButton);
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
