package com.epam.pricingcalc.test;

import com.epam.pricingcalc.model.ComputeEngine;
import com.epam.pricingcalc.page.PricingCalculatorEstimatePage;
import com.epam.pricingcalc.service.ComputeEngineCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleCloudPricingCalculatorEstimationTest extends AbstractGoogleCloudPricingCalculatorTest{
    private static final Logger logger = LogManager.getLogger();
    @Test
    public void pricingCalculatingTest() {
       /* String expectedProvisioningModel = "Regular";
        String expectedInstanceType = "n1-standard-8";
        String expectedRegion = "Frankfurt";
        String expectedLocalSsd = "2x375 GiB";
        String expectedCommitmentTerm = "1 Year";
        String expectedTotalEstimatedCost = "USD 4,024.56 per 1 month";*/
        ComputeEngine computeEngine = ComputeEngineCreator.withCredentialsFromProperty();//fixme second part

        String expectedProvisioningModel = computeEngine.getProvisioningModel();
        String expectedInstanceType = computeEngine.getMachineType();
        String expectedRegion = computeEngine.getDatacenterLocation();
        String expectedLocalSsd = computeEngine.getLocalSsd().replace("GB", "GiB");
        String expectedCommitmentTerm = computeEngine.getCommittedUsage();
        String expectedTotalEstimatedCost = computeEngine.getTotalEstimatedCost();

        PricingCalculatorEstimatePage pricingCalculatorEstimatePage = openPageAndFillDataForEstimating(computeEngine);
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
