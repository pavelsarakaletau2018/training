package com.home.training.tests.mail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.home.training.ui.po.MainPageObject;
import com.home.training.ui.po.SignInPageObject;
import com.home.training.ui.wd.drivermanager.DriverManager;

public class SignInDPTest {
    private static final String NAME = "pavel.sarakaletau@yahoo.com";
    private static final String PASSWORD = "testpassword2";
    private MainPageObject mainPage;
    private String browser;
    WebDriver driver;

    protected SignInDPTest(String browserName) {
        this.browser = browserName;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverManager.initDriver(browser);
    }

    @AfterClass
    public void tearDown() {
        DriverManager.closeDriver();
    }

    @BeforeMethod
    public void doPrepare() {
        mainPage = new MainPageObject(driver);
        mainPage.openPage();
    }

    @Test(description = "Is running by LogInTestFactory")
    public void signInTest() {
        SignInPageObject signInPage = mainPage.goUserSignIn();
        signInPage.setUserName(NAME).goNext().setPassword(PASSWORD).goNext();
        
        Assert.assertTrue(mainPage.isUserSignedIn(), "User state is sign out!");
    }

}
