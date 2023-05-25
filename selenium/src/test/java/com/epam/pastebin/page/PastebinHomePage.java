package com.epam.pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PastebinHomePage extends AbstractPastebinPage {
    private final String HOME_PAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement codeInput;
    @FindBy(id = "postform-name")
    private WebElement nameInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement selectorPasteExpiration;
    @FindBy(xpath = "//li[contains(@id, '10M')]")
    private WebElement optionPasteExpirationTenMinutes;

    @FindBy(id = "select2-postform-format-container")
    private WebElement selectorSyntaxHighlighting;
    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement optionSyntaxHighlightingBash;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(codeInput));
        return this;
    }

    public PastebinHomePage addPasteCode(String code) {
        codeInput.sendKeys(code);
        return this;
    }

    public PastebinHomePage choosePasteExpirationTenMinutes() {
        WebElement selectorOptionTenMinutes = optionPasteExpirationTenMinutes;
        selectorPasteExpiration.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(selectorOptionTenMinutes));
        selectorOptionTenMinutes.click();
        return this;
    }

    public PastebinHomePage addPasteName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public PastebinPastePage clickCreatePaste() {
        createButton.click();
        return new PastebinPastePage(driver);
    }

    public PastebinHomePage chooseSyntaxHighlightingBash() {
        selectorSyntaxHighlighting.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(optionSyntaxHighlightingBash));
        optionSyntaxHighlightingBash.click();
        return this;
    }
}
