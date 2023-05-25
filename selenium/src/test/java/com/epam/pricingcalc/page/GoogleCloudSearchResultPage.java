package com.epam.pricingcalc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchResultPage extends AbstractPage {
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='gsc-results gsc-webResult']//a[.='Google Cloud Platform Pricing Calculator']")
    private WebElement pricingCalculatorLink;
    public GoogleCloudSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("You can not open page. This page can be only result of work other's pages");
    }

    public PricingCalculatorPage clickPricingCalculatorLink(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(pricingCalculatorLink));
        pricingCalculatorLink.click();
        return new PricingCalculatorPage(driver);
    }
}
