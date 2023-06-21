package com.epam.pricingcalc.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger();
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
    @FindBy(id = "select_value_label_89")
    private WebElement provisioningModelSelect;
    @FindBy(id = "select_value_label_91")
    private WebElement seriesSelect;
    @FindBy(id = "select_value_label_92")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add GPUs']")
    private WebElement addGpusCheckbox;
    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement numberOfGpuSelect;
    @FindBy(xpath = "//*[@placeholder='Local SSD']")
    private WebElement localSsdSelect;
    @FindBy(id = "select_value_label_94")
    private WebElement datacenterLocationSelect;
    @FindBy(id = "select_value_label_95")
    private WebElement committedUsageSelect;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;
    @FindBy(id = "input_97")
    private WebElement whatAreInstancesForInput;
    @FindBy(id = "select_value_label_222")
    private WebElement threadsPerCoreSelect;
    @FindBy(id = "select_value_label_90")
    private WebElement machineFamilySelect;
    @FindBy(id = "select_value_label_93")
    private WebElement bootDiskTypeSelect;
    @FindBy(id = "input_127")
    private WebElement bootDiskSizeInput;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Enable Confidential VM service']")
    private WebElement enableConfidentialVmServiceCheckbox;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add Sustained use discounts']")
    private WebElement addSustainedUseDiscountsCheckbox;
    @FindBy(id = "input_131")
    private WebElement instancesUsingEphemeralPublicIpInput;
    @FindBy(id = "input_132")
    private WebElement instancesUsingStaticPublicIpInput;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        goIntoFrames();
    }

    @Override
    protected PricingCalculatorPage openPage() {
        logger.debug("Pricing calculator page is opening.");
        driver.get(PRICING_CALCULATOR_PAGE_URL);
        return this;
    }

    public PricingCalculatorPage chooseSectionComputeEngine() {
        logger.debug("Trying to choose section 'Compute engine'.");
        click(sectionComputeEngine);
        return this;
    }

    public PricingCalculatorPage fillOutNumberOfInstances(String number) {
        logger.debug("Trying to choose number of instances '" + number + "'.");
        sendKeysToInput(numberOfInstancesInput, number);
        return this;
    }

    public PricingCalculatorPage selectOperatingSystem(String operatingSystem) {
        logger.debug("Trying to choose operating system '" + operatingSystem + "'.");
        click(operatingSystemSelect);
        WebElement operatingSystemOption = driver.findElement(
                By.xpath("//*[@id='select_container_110']//div[contains(text(),'" + operatingSystem + "')]"));
        click(operatingSystemOption);
        return this;
    }

    public PricingCalculatorPage selectProvisioningModel(String provisioningModel) {
        logger.debug("Trying to choose provisioning model '" + provisioningModel + "'.");
        click(provisioningModelSelect);
        WebElement provisioningModelOption = driver.findElement(
                By.xpath("//*[@id='select_container_114']//div[contains(text(),'" + provisioningModel + "')]"));
        click(provisioningModelOption);
        return this;
    }

    public PricingCalculatorPage selectMachineSeries(String machineSeries) {
        logger.debug("Trying to choose machine series '" + machineSeries + "'.");
        click(seriesSelect);
        WebElement machineSeriesOption = driver.findElement(
                By.xpath("//*[@id='select_container_122']//div[contains(text(),'" + machineSeries + "')]"));
        click(machineSeriesOption);
        return this;
    }

    public PricingCalculatorPage selectMachineType(String machineType) {
        logger.debug("Trying to choose machine type '" + machineType + "'.");
        click(machineTypeSelect);
        WebElement machineTypeOption = driver.findElement(
                By.xpath("//*[@id='select_container_124']//div[contains(text(),'" + machineType + "')]"));
        click(machineTypeOption);
        return this;
    }

    public PricingCalculatorPage clickAddGpusCheckbox() {
        logger.debug("Trying to click add GPU.");
        click(addGpusCheckbox);
        return this;
    }

    public PricingCalculatorPage selectGpuType(String gpuType) {
        logger.debug("Trying to choose GPU type '" + gpuType + "'.");
        click(gpuTypeSelect);
        clickVisibleOptionWithText(gpuType);
        return this;
    }

    public PricingCalculatorPage selectNumberOfGpu(String numberOfGpu) {
        logger.debug("Trying to choose number of GPU '" + numberOfGpu + "'.");
        click(numberOfGpuSelect);
        clickVisibleOptionWithText(numberOfGpu);
        return this;
    }

    public PricingCalculatorPage selectLocalSsd(String localSsd) {
        logger.debug("Trying to choose local SSD '" + localSsd + "'.");
        click(localSsdSelect);
        clickVisibleOptionWithText(localSsd);
        return this;
    }

    public PricingCalculatorPage selectDataCenterLocation(String dataCenterLocation) {
        logger.debug("Trying to choose datacenter location '" + dataCenterLocation + "'.");
        click(datacenterLocationSelect);
        clickVisibleOptionWithText(dataCenterLocation);
        return this;
    }

    public PricingCalculatorPage selectCommittedUsage(String committedUsage) {
        logger.debug("Trying to choose committed usage '" + committedUsage + "'.");
        click(committedUsageSelect);
        clickVisibleOptionWithText(committedUsage);
        return this;
    }

    public PricingCalculatorEstimatePage clickAddToEstimate() {
        logger.debug("Trying to click 'Add to estimate'.");
        click(addToEstimateButton);
        return new PricingCalculatorEstimatePage(driver);
    }

    public PricingCalculatorPage fillOutWhatAreInstancesFor(String whatAreInstancesFor) {
        logger.debug("Trying to fill out 'What are the instances for' with text '" + whatAreInstancesFor + "'.");
        sendKeysToInput(whatAreInstancesForInput, whatAreInstancesFor);
        return this;
    }

    public PricingCalculatorPage selectMachineFamily(String machineFamily) {
        logger.debug("Trying to choose machine family '" + machineFamily + "'.");
        click(machineFamilySelect);
        WebElement machineFamilyOption = driver.findElement(
                By.xpath("//*[@id='select_container_120']//div[contains(text(),'" + machineFamily + "')]"));
        click(machineFamilyOption);
        return this;
    }

    public PricingCalculatorPage selectThreadsPerCore(String threadsPerCore) {
        logger.debug("Trying to choose threads per core '" + threadsPerCore + "'.");
        click(threadsPerCoreSelect);
        WebElement threadsPerCoreOption = driver.findElement(
                By.xpath("//*[@id='select_container_224']//div[contains(text(),'" + threadsPerCore + "')]"));
        click(threadsPerCoreOption);
        return this;
    }

    public PricingCalculatorPage selectBootDiskType(String bootDiskType) {
        logger.debug("Trying to choose boot disk type '" + bootDiskType + "'.");
        click(bootDiskTypeSelect);
        WebElement bootDiskTypeOption = driver.findElement(
                By.xpath("//*[@id='select_container_126']//div[contains(text(),'" + bootDiskType + "')]"));
        click(bootDiskTypeOption);
        return this;
    }

    public PricingCalculatorPage fillOutBootDiskSize(String bootDiskSize) {
        logger.debug("Trying to fill out boot disk size with value='" + bootDiskSize + "'.");
        sendKeysToInput(bootDiskSizeInput, bootDiskSize);
        return this;
    }

    public PricingCalculatorPage clickEnableConfidentialVmService() {
        logger.debug("Trying to click checkbox 'Enable Confidential VM service'.");
        click(enableConfidentialVmServiceCheckbox);
        return this;
    }

    public boolean isCheckedEnableConfidentialVmService() {
        logger.debug("Trying to find out if is selected checkbox 'Enable Confidential VM service' checkbox.");
        boolean isChecked = isAttributeAriaCheckedEqualsTrue(enableConfidentialVmServiceCheckbox);
        logger.info("Checkbox 'Enable Confidential VM service' is checked = " + isChecked);
        return isChecked;
    }

    public PricingCalculatorPage clickAddSustainedUseDiscounts() {
        logger.debug("Trying to click checkbox 'Add Sustained Use Discounts.'.");
        click(addSustainedUseDiscountsCheckbox);
        return this;
    }

    public boolean isCheckedAddSustainedUseDiscounts() {
        logger.debug("Trying to find out if is checked checkbox 'Add Sustained Use Discounts'.");
        boolean isChecked = isAttributeAriaCheckedEqualsTrue(addSustainedUseDiscountsCheckbox);
        logger.info("Checkbox 'Add Sustained Use Discounts' is checked = " + isChecked);
        return isChecked;
    }

    public boolean isCheckedAddGpus() {
        logger.debug("Trying to find out if is checked checkbox 'Add GPUs'.");
        boolean isChecked = isAttributeAriaCheckedEqualsTrue(addGpusCheckbox);
        logger.info("Checkbox 'Add GPUs' is checked = " + isChecked);
        return isChecked;
    }

    public PricingCalculatorPage fillOutInstancesUsingStaticPublicIp(String instancesUsingStaticPublicIp) {
        logger.debug("Trying to fill out 'Instances using static public IP' with '" + instancesUsingStaticPublicIp + "'.");
        sendKeysToInput(instancesUsingStaticPublicIpInput, instancesUsingStaticPublicIp);
        return this;
    }

    public PricingCalculatorPage fillOutInstancesUsingEphemeralPublicIp(String instancesUsingEphemeralPublicIp) {
        logger.debug("Trying to fill out 'Instances using ephemeral public IP' with '" + instancesUsingEphemeralPublicIp + "'.");
        sendKeysToInput(instancesUsingEphemeralPublicIpInput, instancesUsingEphemeralPublicIp);
        return this;
    }

    private void clickVisibleOptionWithText(String text){
        By optionBy = By.xpath("//div[contains(@id,'select_container_') and @aria-hidden='false']//div[contains(text(),'"
                + text + "')]");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(optionBy));
        WebElement option = driver.findElement(optionBy);
        click(option);
    }

    private void goIntoFrames() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstFrame));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(secondFrame));
    }
}
