package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return this;
    }

    public GoogleCloudStartPage clickSearchButton(){
        logger.debug("Trying to click search button.");
        click(searchButton);
        return this;
    }

    public GoogleCloudStartPage pasteSearchText(String text){
        logger.debug("Trying to paste search text.");
        sendKeysToInput(searchInput, text);
        return this;
    }

    public GoogleCloudSearchResultPage clickEnter(){
        logger.debug("Trying to click Enter.");
        sendKeysToInput(searchInput, Keys.ENTER);
        return new GoogleCloudSearchResultPage(driver);
    }
}
