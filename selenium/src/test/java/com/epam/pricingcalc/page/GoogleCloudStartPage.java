package com.epam.pricingcalc.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudStartPage extends AbstractPage {
    private final String GOOGLE_CLOUD_PAGE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage() {
        driver.get(GOOGLE_CLOUD_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchButton));
        return this;
    }

    public GoogleCloudStartPage clickSearchButton(){
        searchButton.click();
        return this;
    }

    public GoogleCloudStartPage pasteSearchText(String text){
        searchInput.sendKeys(text);
        return this;
    }

    public GoogleCloudSearchResultPage clickEnter(){
        searchInput.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchResultPage(driver);
    }
}
