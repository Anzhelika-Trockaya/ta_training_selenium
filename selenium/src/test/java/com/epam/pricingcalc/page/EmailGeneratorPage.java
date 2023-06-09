package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailGeneratorPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger();
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
        logger.debug("EmailGeneratorPage was opened.");
        return this;
    }

    public EmailGeneratorPage generateEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(generateLink));
        generateLink.click();
        logger.debug("Generate link was clicked.");
        return this;
    }

    public String receiveGeneratedEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(generatedEmailText));
        String generatedEmail = generatedEmailText.getText();
        logger.info("Generated email address: '" + generatedEmail + "'");
        return generatedEmail;
    }

    public EmailGeneratorPage clickCheckInboxButton() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(checkInboxButton));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(checkInboxButton));//todo
        checkInboxButton.click();
        logger.debug("Check inbox button was clicked.");
        return this;
    }

    public EmailGeneratorPage waitForMail() {
        logger.debug("Waiting for email.");
        long startWaitingTime = System.currentTimeMillis();
        int currentWaitingTime;
        while (receiveNumberOfMails().equals("0")) {
            currentWaitingTime = (int) (System.currentTimeMillis() - startWaitingTime);
            if (currentWaitingTime <= MAX_MAIL_WAITING_TIME_MILLIS) {
                logger.debug("Refreshing page.");
                refresh();
            } else {
                logger.error("Mail wasn't received.");
                throw new RuntimeException("Mail wasn't received.");
            }
        }
        return this;
    }

    public String receiveTotalEstimatedMostlyCost() {
        logger.debug("Trying to receive total estimated mostly cost.");
        try {
            driver.switchTo().frame(mailTextFrame);
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOf(totalEstimatedMostlyCostText));
            String totalEstimatedMostlyCost = totalEstimatedMostlyCostText.getText().trim();
            logger.info("Total estimated mostly cost: '" + totalEstimatedMostlyCost + "'");
            return totalEstimatedMostlyCost;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    private String receiveNumberOfMails() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(numberOfMailsText));
        String numberOfMails = numberOfMailsText.getText().split(" ")[0];
        logger.info("Number of mails = '" + numberOfMails + "'");
        return numberOfMails;
    }

    private void refresh() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(refreshButton));
        refreshButton.click();
    }

}
