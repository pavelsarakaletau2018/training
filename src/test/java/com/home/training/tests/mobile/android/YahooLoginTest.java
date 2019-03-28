package com.home.training.tests.mobile.android;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.home.training.ui.mobilepo.MainPageObject;

public class YahooLoginTest extends BrowserBaseTest {
    private static final String NAME = "pavel.sarakaletau@yahoo.com";
    private static final String PASSWORD = "testpassword2";
    private static final String NEW_LINE_DELIMITER = "\\R";
    private MainPageObject mainPage;

    @BeforeMethod(alwaysRun = true)
    public void doPrepare() {
        mainPage = new MainPageObject(driver);
        mainPage.openPage();
    }

    @Test
    public void simpleTest() throws InterruptedException {
        mainPage.goToSignIn().signIn(NAME, PASSWORD);
        Assert.assertEquals(mainPage.getUserProfileName().split(NEW_LINE_DELIMITER)[1], NAME.split("@")[0],
                "User's profile name does not match logination name!");
    }

}
