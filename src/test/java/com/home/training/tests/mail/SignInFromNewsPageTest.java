package com.home.training.tests.mail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.home.training.ui.po.MainPageObject;
import com.home.training.ui.po.NewsPageObject;
import com.home.training.ui.po.SignInPageObject;

public class SignInFromNewsPageTest extends BaseTest {
    private static final String NAME = "pavel.sarakaletau@yahoo.com";
    private static final String PASSWORD = "testpassword2";
    private MainPageObject mainPage;

    @BeforeMethod(alwaysRun = true)
    public void doPrepare() {
        mainPage = new MainPageObject(driver);
        mainPage.openPage();
    }

    @Test(groups = { "signin" }, description = "Perform sign in operation and check the result.")
    public void signInTest() {
        NewsPageObject newsPage = mainPage.goToNews();
        SignInPageObject signInPage = newsPage.goUserSignIn();
        signInPage.setUserName(NAME).goNext().setPassword(PASSWORD).goNext();
        
        SoftAssert loginStateAssert = new SoftAssert();
        loginStateAssert.assertTrue(newsPage.isUserSignedIn(), "User state is sign out!");
        loginStateAssert.assertFalse(newsPage.isUserSignedOut(), "User state is sign out!");
        loginStateAssert.assertAll();
    }

}
