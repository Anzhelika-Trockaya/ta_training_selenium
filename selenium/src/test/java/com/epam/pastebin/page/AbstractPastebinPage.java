package com.epam.pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPastebinPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    protected AbstractPastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract AbstractPastebinPage openPage();
}
