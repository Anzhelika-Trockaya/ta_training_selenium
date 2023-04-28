package com.epam.webdriver.test;

import com.epam.webdriver.page.PastebinHomePage;
import com.epam.webdriver.page.PastebinPastePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PastebinSecondTest extends AbstractPastebinTest{
    @Test
    public void pasteSecondTest() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String name = "how to gain dominance among developers";
        PastebinPastePage pastePage = new PastebinHomePage(driver)
                .openPage()
                .addPasteCode(code)
                .chooseSyntaxHighlightingBash()
                .choosePasteExpirationTenMinutes()
                .addPasteName(name)
                .clickCreatePaste();
        String actualPageTitle = pastePage.receivePageTitle();
        String endingOfTitle = " - Pastebin.com";
        String actualPasteCode = pastePage.getCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualPageTitle, name + endingOfTitle);
        softAssert.assertTrue(code.equals(actualPasteCode));
        softAssert.assertTrue(pastePage.isCodeColorLightGreen("git config"));
        softAssert.assertTrue(pastePage.isCodeColorLightGreen("git reset"));
        softAssert.assertTrue(pastePage.isBracketColorLightGreen("("));
        softAssert.assertTrue(pastePage.isCodeColorLightGreen("git commit-tree"));
        softAssert.assertTrue(pastePage.isBracketColorLightGreen("{"));
        softAssert.assertTrue(pastePage.isCodeColorLightGreen("tree"));
        softAssert.assertTrue(pastePage.isBracketColorLightGreen("}"));
        softAssert.assertTrue(pastePage.isBracketColorLightGreen(")"));
        softAssert.assertTrue(pastePage.isCodeColorLightGreen("git push"));
        softAssert.assertTrue(pastePage.isCodeColorLightGray("\"New Sheriff in Town\""));
        softAssert.assertTrue(pastePage.isCodeColorLightGray("\"Legacy code\""));
        softAssert.assertTrue(pastePage.isCodeColorBlue("--global"));
        softAssert.assertTrue(pastePage.isCodeColorBlue("-m"));
        softAssert.assertTrue(pastePage.isCodeColorBlue("--force"));
        softAssert.assertAll();
    }

}
