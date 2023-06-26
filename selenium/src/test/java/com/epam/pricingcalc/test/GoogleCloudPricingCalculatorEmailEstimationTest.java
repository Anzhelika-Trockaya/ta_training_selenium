package com.epam.pricingcalc.test;

import com.epam.pricingcalc.driver.DriverSingleton;
import com.epam.pricingcalc.model.ComputeEngine;
import com.epam.pricingcalc.page.EmailGeneratorPage;
import com.epam.pricingcalc.page.PricingCalculatorEmailEstimatePage;
import com.epam.pricingcalc.service.ComputeEngineCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPricingCalculatorEmailEstimationTest extends AbstractGoogleCloudPricingCalculatorTest {
    @Test
    public void emailEstimateTest() {
        String expectedTotalEstimatedMostlyCost = "USD 4,024.56";
        ComputeEngine computeEngine = ComputeEngineCreator.withCredentialsFromProperty();
        PricingCalculatorEmailEstimatePage pricingCalculatorEmailEstimatePage = openPageAndFillDataForEstimating(computeEngine)
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
}
