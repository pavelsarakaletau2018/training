package com.home.training.tests.mobile.android;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.home.training.ui.mobilepo.MainPageObject;

public class YahooLogoutTest extends BrowserBaseTest {
    private static final String NAME = "pavel.sarakaletau@yahoo.com";
    private static final String PASSWORD = "testpassword2";
    private MainPageObject mainPage;

    @BeforeMethod(alwaysRun = true)
    public void doPrepare() {
        mainPage = new MainPageObject(driver);
        mainPage.openPage();
        mainPage.goToSignIn().signIn(NAME, PASSWORD);
    }

    @Test
    public void simpleTest() throws InterruptedException {
        mainPage.doSignOut();

        Assert.assertFalse((mainPage.getUserProfileName().contains(NAME.split("@")[0])),
                "User are signed in!");
    }

}
