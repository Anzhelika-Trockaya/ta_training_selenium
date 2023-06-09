package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudStartPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger();
    private final String GOOGLE_CLOUD_PAGE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage() {
        logger.debug("Google cloud start page is opening.");
        driver.get(GOOGLE_CLOUD_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchButton));
        return this;
    }

    public GoogleCloudStartPage clickSearchButton(){
        searchButton.click();
        logger.debug("Search button was clicked.");
        return this;
    }

    public GoogleCloudStartPage pasteSearchText(String text){
        searchInput.sendKeys(text);
        logger.debug("Search text was pasted.");
        return this;
    }

    public GoogleCloudSearchResultPage clickEnter(){
        searchInput.sendKeys(Keys.ENTER);
        logger.debug("Key Enter was clicked.");
        return new GoogleCloudSearchResultPage(driver);
    }
}
