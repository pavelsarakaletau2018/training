package com.home.training.tests.mail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.home.training.ui.po.MainPageObject;
import com.home.training.ui.po.SignInPageObject;

public class SignOutTest extends BaseTest {
    MainPageObject mainPage;

    @BeforeMethod(alwaysRun = true)
    public void doPrepare() {
        mainPage = new MainPageObject(driver);
        SignInPageObject signInPage = mainPage.openPage().goUserSignIn();
        signInPage.setUserName("pavel.sarakaletau@yahoo.com")
                .goNext().setPassword("testpassword2").goNext();
    }

    @Test(groups = { "signout" }, description = "Perform sign out operation and check the result.")
    public void signOutTest() {
        mainPage.doUserSignOut();
        
        SoftAssert loginStateAssert = new SoftAssert();
        loginStateAssert.assertTrue(mainPage.isUserSignedOut(), "User state is signed in!");
        loginStateAssert.assertFalse(mainPage.isUserSignedIn(), "User state is signed in!");
        loginStateAssert.assertAll();
        
    }

}
