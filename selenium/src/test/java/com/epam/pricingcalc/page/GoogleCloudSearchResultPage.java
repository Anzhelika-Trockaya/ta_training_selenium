package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchResultPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger();
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='gsc-results gsc-webResult']//a[.='Google Cloud Pricing Calculator']")
    private WebElement pricingCalculatorLink;
    public GoogleCloudSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        logger.error("You can not open page. This page can be only result of work other's pages");
        throw new RuntimeException("You can not open page. This page can be only result of work other's pages");
    }

    public PricingCalculatorPage clickPricingCalculatorLink(){
        logger.debug("Trying click result, contains 'Google Cloud Pricing Calculator'.");
        click(pricingCalculatorLink);
        return new PricingCalculatorPage(driver);
    }
}
