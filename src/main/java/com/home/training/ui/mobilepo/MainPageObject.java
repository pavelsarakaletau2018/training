package com.home.training.ui.mobilepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MainPageObject extends AbstractPage {

    private static final Logger LOG = LogManager.getLogger();
    private static final String BASE_URL = "https://yahoo.com/";

    @FindBy(id = "header-profile-button")
    private WebElement userProfilePic;

    @FindBy(id = "profile-user-info")
    private WebElement userProfile;

    @FindBy(id = "profile-signout-link")
    private WebElement signOut;

    @FindBy(xpath = "//*[contains(@class,'button signout')]")
    private WebElement confirmSignOut;

    public MainPageObject(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MainPageObject openPage() {
        LOG.info("Opening page: " + BASE_URL);
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SignInPageObject goToSignIn() {
        userProfilePic.click();
        userProfile.click();
        return new SignInPageObject(driver);
    }

    public MainPageObject doSignOut() {
        userProfilePic.click();
        signOut.click();
        confirmSignOut.click();
        return new MainPageObject(driver);
    }

    public String getUserProfileName() {
        userProfilePic.click();
        String fullProfileText = userProfile.getText();
        // to close menu
        userProfilePic.click();
        // user name is placed the on second line
        return fullProfileText;
    }

}
