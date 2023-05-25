package com.epam.pricingcalc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorEstimatePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='resultBlock']/descendant::*[contains(text(),'Region:')]")
    private WebElement regionText;
    @FindBy(xpath = "//*[@id='resultBlock']/descendant::*[contains(text(),'Provisioning model:')]")
    private WebElement provisioningModelText;
    @FindBy(xpath = "//*[@id='resultBlock']/descendant::*[contains(text(),'Instance type:')]")
    private WebElement instanceTypeText;
    @FindBy(xpath = "//*[@id='resultBlock']/descendant::*[contains(text(),'Local SSD:')]")
    private WebElement localSsdText;
    @FindBy(xpath = "//*[@id='resultBlock']/descendant::*[contains(text(),'Commitment term:')]")
    private WebElement commitmentTermText;
    @FindBy(xpath = "//*[@class = 'cpc-cart-total']")
    private WebElement totalEstimatedCostText;
    @FindBy(id="Email Estimate")
    private WebElement emailEstimateButton;


    protected PricingCalculatorEstimatePage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(totalEstimatedCostText));
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("You can not open this page. It can be only a result of actions on other page.");
    }


    public String receiveProvisioningModel() {
        return takeOutValueFromProperty(provisioningModelText.getText());
    }

    public String receiveInstanceType() {
        return takeOutValueFromProperty(instanceTypeText.getText());
    }

    public String receiveRegion() {
        return takeOutValueFromProperty(regionText.getText());
    }

    public String receiveLocalSsd() {
        return takeOutValueFromProperty(localSsdText.getText());
    }

    public String receiveCommitmentTerm() {
        return takeOutValueFromProperty(commitmentTermText.getText());
    }

    public String receiveTotalEstimatedCost() {
        return takeOutValueFromProperty(totalEstimatedCostText.getText());
    }

    public PricingCalculatorEmailEstimatePage clickEmailEstimateButton(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(emailEstimateButton));
        emailEstimateButton.click();
        return new PricingCalculatorEmailEstimatePage(driver);
    }

    private String takeOutValueFromProperty(String text) {
        int startIndex = text.indexOf(':') + 1;
        int indexOfEnter = text.indexOf('\n');
        return indexOfEnter == -1 ? text.substring(startIndex).trim() : text.substring(startIndex, indexOfEnter).trim();
    }

}
