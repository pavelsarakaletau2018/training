package com.home.training.ui.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObject extends AbstractPage {

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
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SignInPageObject goSignIn() {
        waitEnabled(signInButton).click();
        return new SignInPageObject(driver);
    }

    public MailPageObject gotoMail() {
        waitEnabled(mailButton).click();
        return new MailPageObject(driver);
    }

    public MainPageObject signOut() {
        waitEnabled(userPic).click();
        waitEnabled(signOutLink).click();
        return new MainPageObject(driver);
    }

    public boolean isSignInState() {
        return waitPresent(userPic).isDisplayed();
    }

    public boolean isSignOutState() {
        return waitPresent(signInButton).isDisplayed();
    }

}
