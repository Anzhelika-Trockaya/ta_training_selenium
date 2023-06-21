package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorEstimatePage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger();
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
    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateButton;


    protected PricingCalculatorEstimatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        logger.error("You can not open this page. It can be only a result of actions on other page.");
        throw new RuntimeException("You can not open this page. It can be only a result of actions on other page.");
    }


    public String receiveProvisioningModel() {
        String provisioningModel = receiveValueFromPropertyTextElement(provisioningModelText);
        logger.info("Received provisioning model :'" + provisioningModel + "'");
        return provisioningModel;
    }

    public String receiveInstanceType() {
        String instanceType = receiveValueFromPropertyTextElement(instanceTypeText);
        logger.info("Received instance type :'" + instanceType + "'");
        return instanceType;
    }

    public String receiveRegion() {
        String region = receiveValueFromPropertyTextElement(regionText);
        logger.info("Received region : '" + region + "'");
        return region;
    }

    public String receiveLocalSsd() {
        String localSsd = receiveValueFromPropertyTextElement(localSsdText);
        logger.info("Received local SSD : '" + localSsd + "'");
        return localSsd;
    }

    public String receiveCommitmentTerm() {
        String commitmentTerm = receiveValueFromPropertyTextElement(commitmentTermText);
        logger.info("Received commitment term : '" + commitmentTerm + "'");
        return commitmentTerm;
    }

    public String receiveTotalEstimatedCost() {
        String totalEstimatedCost = receiveValueFromPropertyTextElement(totalEstimatedCostText);
        logger.info("Received total estimated cost :'" + totalEstimatedCost + "'");
        return totalEstimatedCost;
    }

    public PricingCalculatorEmailEstimatePage clickEmailEstimateButton() {
        logger.debug("Trying to click button 'Email estimate'.");
        click(emailEstimateButton);
        return new PricingCalculatorEmailEstimatePage(driver);
    }

    private String receiveValueFromPropertyTextElement(WebElement propertyTextElement){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(propertyTextElement));
        return takeOutValueFromProperty(propertyTextElement.getText());
    }

    private String takeOutValueFromProperty(String text) {
        int startIndex = text.indexOf(':') + 1;
        int indexOfEnter = text.indexOf('\n');
        return indexOfEnter == -1 ? text.substring(startIndex).trim() : text.substring(startIndex, indexOfEnter).trim();
    }

}
