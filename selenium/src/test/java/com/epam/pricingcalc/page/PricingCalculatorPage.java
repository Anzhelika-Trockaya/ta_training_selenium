package com.epam.pricingcalc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage {
    private final String PRICING_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//iframe[@src='https://cloud.google.com/frame/products/calculator/index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0.frame?hl=ru']")
    private WebElement firstFrame;
    @FindBy(id = "myFrame")
    private WebElement secondFrame;
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']/div")
    private WebElement sectionComputeEngine;
    @FindBy(id = "input_96")
    private WebElement numberOfInstancesInput;
    @FindBy(id = "select_value_label_88")
    private WebElement operatingSystemSelect;
    @FindBy(id = "select_option_98")
    private WebElement freeOperatingSystemOption;
    @FindBy(id = "select_value_label_89")
    private WebElement provisioningModelSelect;
    @FindBy(id = "select_option_111")
    private WebElement regularProvisioningModelOption;
    @FindBy(id = "select_value_label_91")
    private WebElement seriesSelect;
    @FindBy(id = "select_option_212")
    private WebElement seriesNOneOption;
    @FindBy(id = "select_value_label_92")
    private WebElement machineTypeSelect;
    @FindBy(id = "select_option_451")
    private WebElement machineTypeNOneStandardEightOption;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add GPUs']")
    private WebElement addGpuCheckBox;
    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//div[contains(text(),'NVIDIA Tesla P100')]")
    private WebElement gpuTypeNvidiaTeslaPHundredOption;
    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement numberOfGpuSelect;
    @FindBy(xpath = "//*[@id='select_option_497']/div[contains(text(),'1')]")
    private WebElement numberOfGpuOneOption;
    @FindBy(id = "select_value_label_445")
    private WebElement localSsdSelect;
    @FindBy(id = "select_option_472")
    private WebElement localSsdTwoTimesThreeHundredSeventyFiveGbOption;
    @FindBy(id = "select_value_label_94")
    private WebElement datacenterLocationSelect;
    @FindBy(id = "select_option_253")
    private WebElement dataCenterLocationFrankfurtEuropeWestThreeOption;
    @FindBy(id = "select_value_label_95")
    private WebElement committedUsageSelect;
    @FindBy(id = "select_option_134")
    private WebElement committedUsageOneYearOption;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        goIntoFrames();
    }

    @Override
    protected AbstractPage openPage() {
        driver.get(PRICING_CALCULATOR_PAGE_URL);
        return this;
    }


    public PricingCalculatorPage chooseSectionComputeEngine() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(sectionComputeEngine));
        sectionComputeEngine.click();
        return this;
    }

    public PricingCalculatorPage fillOutNumberOfInstances(int number) {
        if (number < 1) {
            throw new RuntimeException("Number of instances has to be bigger than zero.");
        }
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(numberOfInstancesInput));
        numberOfInstancesInput.sendKeys(String.valueOf(number));
        return this;
    }

    public PricingCalculatorPage selectFreeOperatingSystem() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(operatingSystemSelect));
        operatingSystemSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(freeOperatingSystemOption));
        freeOperatingSystemOption.click();
        return this;
    }

    public PricingCalculatorPage selectRegularProvisioningModel() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(provisioningModelSelect));
        provisioningModelSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(regularProvisioningModelOption));
        regularProvisioningModelOption.click();
        return this;
    }

    public PricingCalculatorPage selectMachineSeriesNOne() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(seriesSelect));
        seriesSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(seriesNOneOption));
        seriesNOneOption.click();
        return this;
    }

    public PricingCalculatorPage selectMachineTypeNOneStandardEight() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(machineTypeSelect));
        machineTypeSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(machineTypeNOneStandardEightOption));
        machineTypeNOneStandardEightOption.click();
        return this;
    }

    public PricingCalculatorPage clickAddGpu() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(addGpuCheckBox));
        addGpuCheckBox.click();
        return this;
    }

    public PricingCalculatorPage selectGpuTypeNvidiaTeslaPHundred() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(gpuTypeSelect));
        gpuTypeSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(gpuTypeNvidiaTeslaPHundredOption));
        gpuTypeNvidiaTeslaPHundredOption.click();
        return this;
    }

    public PricingCalculatorPage selectNumberOfGpuOne() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(numberOfGpuSelect));
        numberOfGpuSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(numberOfGpuOneOption));
        numberOfGpuOneOption.click();
        return this;
    }

    public PricingCalculatorPage selectLocalSsdTwoTimesThreeHundredSeventyFiveGb() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(localSsdSelect));
        localSsdSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(localSsdTwoTimesThreeHundredSeventyFiveGbOption));
        localSsdTwoTimesThreeHundredSeventyFiveGbOption.click();
        return this;
    }

    public PricingCalculatorPage selectDataCenterLocationFrankfurtEuropeWestThree() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(datacenterLocationSelect));
        datacenterLocationSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(dataCenterLocationFrankfurtEuropeWestThreeOption));
        dataCenterLocationFrankfurtEuropeWestThreeOption.click();
        return this;
    }

    public PricingCalculatorPage selectCommittedUsageOneYear() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(committedUsageSelect));
        committedUsageSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(committedUsageOneYearOption));
        committedUsageOneYearOption.click();
        return this;
    }

    public PricingCalculatorEstimatePage clickAddToEstimate() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();
        return new PricingCalculatorEstimatePage(driver);
    }

    private void goIntoFrames() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstFrame));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(secondFrame));
    }
}
