package com.home.training.ui.mobilepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignInPageObject extends AbstractPage{
    private static final Logger LOG = LogManager.getLogger();
    private static final String BASE_URL = "https://login.yahoo.com/";

    @FindBy(id = "login-username")
    private WebElement emailField;
    
    @FindBy(id = "login-passwd")
    private WebElement passwordField;
    
    @FindBy(id = "login-signin")
    private WebElement nextButton;
    
    public SignInPageObject(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public SignInPageObject openPage() {
        LOG.info("Opening page: " + BASE_URL);
        driver.navigate().to(BASE_URL);
        return this;
    }

   
    public MainPageObject signIn(String login, String password) {
        emailField.sendKeys(login);
        nextButton.click();
        passwordField.sendKeys(password);
        nextButton.click();
        return new MainPageObject(driver);
    }
}
