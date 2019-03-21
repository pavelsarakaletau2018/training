package com.home.training.ui.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPageObject extends AbstractPage {

    private static final String BASE_URL = "https://login.yahoo.com/";

    @FindBy(xpath = "//input[@id='login-username']")
    @CacheLookup
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='login-passwd']")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(css = "#login-signin")
    // @FindBy(xpath = "//*[@id='login-signin']")
    private WebElement nextButton;

    public SignInPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public SignInPageObject openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SignInPageObject setUserName(String name) {
        waitEnabled(userNameField).sendKeys(name);
        return this;
    }

    public SignInPageObject setPassword(String password) {
        waitEnabled(passwordField).sendKeys(password);
        return this;
    }

    public SignInPageObject goNext() {
        // advertising tab in chrome
        // waitEnabled(nextButton).click();
        clickByJavaScript(nextButton);
        return this;
    }

}
