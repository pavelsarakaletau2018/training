package com.home.training.ui.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPageObject extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger();

    private static final String BASE_URL = "https://login.yahoo.com/";

    @FindBy(xpath = "//input[@id='login-username']")
    @CacheLookup
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='login-passwd']")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(css = "#login-signin")
    private WebElement nextButton;

    public SignInPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public SignInPageObject openPage() {
        LOG.info("Opening page...");
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SignInPageObject setUserName(String name) {
        LOG.info("Set user name: " + name);
        waitEnabled(userNameField).sendKeys(name);
        return this;
    }

    public SignInPageObject setPassword(String password) {
        LOG.info("Set user password: " + password);
        waitEnabled(passwordField).sendKeys(password);
        return this;
    }

    public SignInPageObject goNext() {
        LOG.info("Click 'next'");
        // advertising tab in chrome
        clickByJavaScript(nextButton);
        return this;
    }

}
