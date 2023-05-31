package com.epam.pricingcalc.test;

import com.epam.pricingcalc.driver.DriverSingleton;
import com.epam.pricingcalc.page.EmailGeneratorPage;
import com.epam.pricingcalc.page.GoogleCloudStartPage;
import com.epam.pricingcalc.page.PricingCalculatorEmailEstimatePage;
import com.epam.pricingcalc.page.PricingCalculatorEstimatePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleCloudPricingCalculatorTest extends AbstractGoogleCloudTest {
    @Test
    public void pricingCalculatingTest() {
        String expectedProvisioningModel = "Regular";
        String expectedInstanceType = "n1-standard-8";
        String expectedRegion = "Frankfurt";
        String expectedLocalSsd = "2x375 GiB";
        String expectedCommitmentTerm = "1 Year";
        String expectedTotalEstimatedCost = "USD 4,024.56 per 1 month";

        PricingCalculatorEstimatePage pricingCalculatorEstimatePage = openPageAndFillDataForEstimating();
        String actualProvisioningModel = pricingCalculatorEstimatePage.receiveProvisioningModel();
        String actualInstanceType = pricingCalculatorEstimatePage.receiveInstanceType();
        String actualRegion = pricingCalculatorEstimatePage.receiveRegion();
        String actualLocalSsd = pricingCalculatorEstimatePage.receiveLocalSsd();
        String actualCommitmentTerm = pricingCalculatorEstimatePage.receiveCommitmentTerm();
        String actualTotalEstimatedCost = pricingCalculatorEstimatePage.receiveTotalEstimatedCost();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualProvisioningModel, expectedProvisioningModel);
        softAssert.assertEquals(actualInstanceType, expectedInstanceType);
        softAssert.assertEquals(actualRegion, expectedRegion);
        softAssert.assertEquals(actualLocalSsd, expectedLocalSsd);
        softAssert.assertEquals(actualCommitmentTerm, expectedCommitmentTerm);
        softAssert.assertEquals(actualTotalEstimatedCost, expectedTotalEstimatedCost);
        softAssert.assertAll();
    }

    @Test
    public void emailEstimateTest() {
        String expectedTotalEstimatedMostlyCost = "USD 4,024.56";
        PricingCalculatorEmailEstimatePage pricingCalculatorEmailEstimatePage = openPageAndFillDataForEstimating()
                .clickEmailEstimateButton();
        DriverSingleton.createAnotherTab();
        EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(driver)
                .openPage()
                .generateEmail();
        String generatedEmail = emailGeneratorPage.receiveGeneratedEmail();
        DriverSingleton.switchToOtherTabIfExists();
        pricingCalculatorEmailEstimatePage
                .pasteEmail(generatedEmail)
                .clickSendEmail();
        DriverSingleton.switchToOtherTabIfExists();
        String actualTotalEstimatedMostlyCost = emailGeneratorPage
                .clickCheckInboxButton()
                .waitForMail()
                .receiveTotalEstimatedMostlyCost();
        Assert.assertEquals(expectedTotalEstimatedMostlyCost, actualTotalEstimatedMostlyCost);
    }


    private PricingCalculatorEstimatePage openPageAndFillDataForEstimating() {
        String searchText = "Google Cloud Platform Pricing Calculator";
        return new GoogleCloudStartPage(driver)
                .openPage()
                .clickSearchButton()
                .pasteSearchText(searchText)
                .clickEnter()
                .clickPricingCalculatorLink()
                .chooseSectionComputeEngine()
                .fillOutNumberOfInstances(4)
                .selectFreeOperatingSystem()
                .selectRegularProvisioningModel()
                .selectMachineSeriesNOne()
                .selectMachineTypeNOneStandardEight()
                .clickAddGpu()
                .selectGpuTypeNvidiaTeslaPHundred()
                .selectNumberOfGpuOne()
                .selectLocalSsdTwoTimesThreeHundredSeventyFiveGb()
                .selectDataCenterLocationFrankfurtEuropeWestThree()
                .selectCommittedUsageOneYear()
                .clickAddToEstimate();
    }
}
