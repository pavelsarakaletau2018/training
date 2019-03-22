package com.home.training.ui.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObject extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger();

    private static final String BASE_URL = "https://www.yahoo.com";

    @FindBy(xpath = "//a[@id='uh-signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='uh-mail-link']")
    private WebElement mailButton;

    @FindBy(xpath = "//*[@id='uh-profile']")
    private WebElement userPic;

    @FindBy(xpath = "//a[@id='uh-signout']")
    private WebElement signOutLink;

    public MainPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MainPageObject openPage() {
        LOG.info("Opening page: " + BASE_URL);
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SignInPageObject goSignIn() {
        LOG.info("Go to sign in...");
        waitEnabled(signInButton).click();
        return new SignInPageObject(driver);
    }

    public MailPageObject gotoMail() {
        LOG.info("Go to mail...");
        waitEnabled(mailButton).click();
        return new MailPageObject(driver);
    }

    public MainPageObject signOut() {
        LOG.info("Sign out...");
        waitEnabled(userPic).click();
        waitEnabled(signOutLink).click();
        return new MainPageObject(driver);
    }

    public boolean isSignInState() {
        LOG.info("Check if signed in...");
        return isElementPresent(userPic);
    }

    public boolean isSignOutState() {
        LOG.info("Check if signed out...");
        return signInButton.isDisplayed();
    }

}
