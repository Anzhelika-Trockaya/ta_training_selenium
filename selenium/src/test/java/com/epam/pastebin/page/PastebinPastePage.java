package com.epam.pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPastePage extends AbstractPastebinPage {
    @FindBy(className = "highlighted-code")
    private WebElement code;

    public PastebinPastePage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(code));
    }

    protected AbstractPastebinPage openPage() {
        throw new RuntimeException("You can not open page. This page can be only result of work other's pages");
    }

    public String receivePageTitle() {
        return driver.getTitle();
    }

    public boolean isCodeColorLightGreen(String code) {
        WebElement codeElement = driver.findElement(
                By.xpath("//div[@class='highlighted-code']/descendant::span[text()='" + code + "']"));
        return codeElement.getCssValue("color").contains("rgba(185, 202, 74, 1)");
    }

    public boolean isBracketColorLightGreen(String bracket) {
        WebElement codeElement = driver.findElement(
                By.xpath("//div[@class='highlighted-code']/descendant::span[text()='" + bracket + "']"));
        return codeElement.getCssValue("color").contains("rgba(189, 206, 61, 1)");
    }

    public boolean isCodeColorBlue(String code) {
        WebElement codeElement = driver.findElement(
                By.xpath("//div[@class='highlighted-code']/descendant::span[text()='" + code + "']"));
        return codeElement.getCssValue("color").contains("rgba(122, 166, 218, 1)");
    }

    public boolean isCodeColorLightGray(String code) {
        WebElement codeElement = driver.findElement(
                By.xpath("//div[@class='highlighted-code']/descendant::span[text()='" + code + "']"));
        return codeElement.getCssValue("color").contains("rgba(196, 209, 222, 1)");
    }

    public String getCode() {
        WebElement code = driver.findElement(By.xpath("//ol[@class='bash']"));
        return code.getText();
    }
}
