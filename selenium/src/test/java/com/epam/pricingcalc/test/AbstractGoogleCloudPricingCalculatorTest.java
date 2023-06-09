package com.epam.pricingcalc.test;

import com.epam.pricingcalc.driver.DriverSingleton;
import com.epam.pricingcalc.model.ComputeEngine;
import com.epam.pricingcalc.page.GoogleCloudStartPage;
import com.epam.pricingcalc.page.PricingCalculatorEstimatePage;
import com.epam.pricingcalc.page.PricingCalculatorPage;
import com.epam.pricingcalc.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public abstract class AbstractGoogleCloudPricingCalculatorTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
        driver = null;
    }

    protected PricingCalculatorEstimatePage openPageAndFillDataForEstimating(ComputeEngine computeEngine) {//fixme start here!!!
        String searchText = "Google Cloud Platform Pricing Calculator";//todo refactor отдельно открытие
        PricingCalculatorPage pricingCalculatorPage = new GoogleCloudStartPage(driver)
                .openPage()
                .clickSearchButton()
                .pasteSearchText(searchText)
                .clickEnter()
                .clickPricingCalculatorLink();


        pricingCalculatorPage.chooseSectionComputeEngine();
        if (computeEngine.getNumberOfInstances() != null) {
            pricingCalculatorPage.fillOutNumberOfInstances(computeEngine.getNumberOfInstances());
        }
        if (computeEngine.getWhatAreInstancesFor() != null) {
            pricingCalculatorPage.fillOutWhatAreInstancesFor(computeEngine.getWhatAreInstancesFor());
        }
        if (computeEngine.getOperatingSystem() != null) {
            pricingCalculatorPage.selectOperatingSystem(computeEngine.getOperatingSystem());
        }
        if (computeEngine.getProvisioningModel() != null) {
            pricingCalculatorPage.selectProvisioningModel(computeEngine.getProvisioningModel());
        }
        if (computeEngine.getMachineFamily() != null) {
            pricingCalculatorPage.selectMachineFamily(computeEngine.getMachineFamily());
        }
        if (computeEngine.getMachineSeries() != null) {
            pricingCalculatorPage.selectMachineSeries(computeEngine.getMachineSeries());
        }
        if (computeEngine.getMachineType() != null) {
            pricingCalculatorPage.selectMachineType(computeEngine.getMachineType());
        }
        if (computeEngine.getThreadsPerCore() != null) {
            pricingCalculatorPage.selectThreadsPerCore(computeEngine.getThreadsPerCore());
        }
        if (computeEngine.getBootDiskType() != null) {
            pricingCalculatorPage.selectBootDiskType(computeEngine.getBootDiskType());
        }
        if (computeEngine.getBootDiskSize() != null) {
            pricingCalculatorPage.fillOutBootDiskSize(computeEngine.getBootDiskSize());
        }
        if (computeEngine.isEnableConfidentialVmService() && !pricingCalculatorPage.isCheckedEnableConfidentialVmService()) {
            pricingCalculatorPage.clickEnableConfidentialVmService();
        }
        if (computeEngine.isAddSustainedUseDiscounts() && !pricingCalculatorPage.isCheckedAddSustainedUseDiscounts()) {
            pricingCalculatorPage.clickAddSustainedUseDiscounts();
        }
        if (computeEngine.isAddGpus() && !pricingCalculatorPage.isCheckedAddGpus()) {
            pricingCalculatorPage.clickAddGpusCheckbox();
        }
        if (computeEngine.getGpuType() != null) {
            pricingCalculatorPage.selectGpuType(computeEngine.getGpuType());
        }
        if (computeEngine.getNumberOfGpus() != null) {
            pricingCalculatorPage.selectNumberOfGpu(computeEngine.getNumberOfGpus());
        }
        if (computeEngine.getLocalSsd() != null) {
            pricingCalculatorPage.selectLocalSsd(computeEngine.getLocalSsd());
        }
        if (computeEngine.getDatacenterLocation() != null) {
            pricingCalculatorPage.selectDataCenterLocation(computeEngine.getDatacenterLocation());
        }
        if (computeEngine.getInstancesUsingEphemeralPublicIp() != null) {
            pricingCalculatorPage.fillOutInstancesUsingStaticPublicIp(computeEngine.getInstancesUsingStaticPublicIp());
        }
        if (computeEngine.getInstancesUsingEphemeralPublicIp() != null) {
            pricingCalculatorPage.fillOutInstancesUsingEphemeralPublicIp(computeEngine.getInstancesUsingEphemeralPublicIp());
        }
        if (computeEngine.getCommittedUsage() != null) {
            pricingCalculatorPage.selectCommittedUsage(computeEngine.getCommittedUsage());
        }
        return pricingCalculatorPage.clickAddToEstimate();
    }
}
