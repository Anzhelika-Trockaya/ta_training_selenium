package com.epam.pricingcalc.util;

import com.epam.pricingcalc.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot();
    }

    private void saveScreenShot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/"+getCurrentTimeAsString()+".png"));
        } catch(IOException ioException){
            logger.error("Failed to save screenshot. "+ioException.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu_MM_dd_HH_mm_ss");
        return ZonedDateTime.now().format(formatter);
    }
}
