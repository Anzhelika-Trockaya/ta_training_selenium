package com.epam.webdriver.test;

import com.epam.webdriver.page.PastebinHomePage;
import org.testng.annotations.Test;

public class PastebinFirstTest extends AbstractPastebinTest {
    @Test
    public void createPasteFirstTest() {
        String code = "Hello from WebDriver";
        String name = "helloweb";

        new PastebinHomePage(driver)
                .openPage()
                .addPasteCode(code)
                .choosePasteExpirationTenMinutes()
                .addPasteName(name)
                .clickCreatePaste();
    }

}
