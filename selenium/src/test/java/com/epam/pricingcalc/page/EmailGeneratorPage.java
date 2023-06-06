package com.epam.pricingcalc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailGeneratorPage extends AbstractPage {
    private final String EMAIL_GENERATOR_PAGE_URL = "https://yopmail.com/en/";
    private final int MAX_MAIL_WAITING_TIME_MILLIS = 10000;
    @FindBy(xpath = "//a[@href='email-generator']")
    private WebElement generateLink;
    @FindBy(id = "geny")
    private WebElement generatedEmailText;
    @FindBy(xpath = "//span[contains(text(),'Check Inbox')]")
    private WebElement checkInboxButton;
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//*[@id='mail']/descendant::table[2]/tbody/tr[2]/td[2]/h3")
    private WebElement totalEstimatedMostlyCostText;
    @FindBy(id = "ifmail")
    private WebElement mailTextFrame;
    @FindBy(xpath = "//*[@id='nbmail']")
    private WebElement numberOfMailsText;

    public EmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EmailGeneratorPage openPage() {
        driver.get(EMAIL_GENERATOR_PAGE_URL);
        return this;
    }

    public EmailGeneratorPage generateEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(generateLink));
        generateLink.click();
        return this;
    }

    public String receiveGeneratedEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(generatedEmailText));
        return generatedEmailText.getText();
    }

    public EmailGeneratorPage clickCheckInboxButton() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(checkInboxButton));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(checkInboxButton));
        checkInboxButton.click();
        return this;
    }

    public EmailGeneratorPage waitForMail() {
        long startWaitingTime = System.currentTimeMillis();
        int currentWaitingTime;
        while (isNumberOfMailsZero()) {
            currentWaitingTime = (int) (System.currentTimeMillis() - startWaitingTime);
            if (currentWaitingTime <= MAX_MAIL_WAITING_TIME_MILLIS) {
                refresh();
            } else {
                throw new RuntimeException("Mail isn't received.");
            }
        }
        return this;
    }

    public String receiveTotalEstimatedMostlyCost() {
        try {
            driver.switchTo().frame(mailTextFrame);
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOf(totalEstimatedMostlyCostText));
            return totalEstimatedMostlyCostText.getText().trim();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    private boolean isNumberOfMailsZero() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(numberOfMailsText));
        return numberOfMailsText.getText().trim().startsWith("0");
    }

    private void refresh() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(refreshButton));
        refreshButton.click();
    }

}
