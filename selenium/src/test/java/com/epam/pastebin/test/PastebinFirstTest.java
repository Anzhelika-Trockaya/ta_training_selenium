package com.epam.pastebin.test;

import com.epam.pastebin.page.PastebinHomePage;
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
