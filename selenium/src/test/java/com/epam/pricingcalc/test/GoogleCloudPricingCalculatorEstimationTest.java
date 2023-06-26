package com.epam.pricingcalc.test;

import com.epam.pricingcalc.model.ComputeEngine;
import com.epam.pricingcalc.page.PricingCalculatorEstimatePage;
import com.epam.pricingcalc.service.ComputeEngineCreator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleCloudPricingCalculatorEstimationTest extends AbstractGoogleCloudPricingCalculatorTest{
    @Test
    public void pricingCalculatingTest() {
        ComputeEngine computeEngine = ComputeEngineCreator.withCredentialsFromProperty();
        PricingCalculatorEstimatePage pricingCalculatorEstimatePage = openPageAndFillDataForEstimating(computeEngine);

        String expectedProvisioningModel = computeEngine.getProvisioningModel();
        String expectedInstanceType = computeEngine.getMachineType();
        String expectedRegion = computeEngine.getDatacenterLocation();
        String expectedLocalSsd = computeEngine.getLocalSsd().replace("GB", "GiB");
        String expectedCommitmentTerm = computeEngine.getCommittedUsage();
        String expectedTotalEstimatedCost = computeEngine.getTotalEstimatedCost();

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

}
