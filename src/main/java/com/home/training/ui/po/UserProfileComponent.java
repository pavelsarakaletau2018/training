package com.home.training.ui.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileComponent extends AbstractComponent {
    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//a[@id='uh-mail' or @id='uh-mail-link']")
    private WebElement mailButton;

    @FindBy(xpath = "//*[@id='uh-profile']")
    private WebElement userProfilePic;

    @FindBy(xpath = "//a[@id='uh-signedout' or @id='uh-signout']")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@id='uh-signedin' or @id='uh-signin']")
    private WebElement signInButton;

    public UserProfileComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
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
        waitEnabled(userProfilePic).click();
        waitPresent(signOutLink).click();
        return new MainPageObject(driver);
    }

    public boolean isSignInState() {
        LOG.info("Check if signed in...");
        return isElementPresent(userProfilePic);
    }

    public boolean isSignOutState() {
        LOG.info("Check if signed out...");
        return isElementPresent(signInButton);
    }

}
