package com.home.training.ui.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage extends AbstractComponent {

    private final UserProfileComponent userProfileComponent;
    public abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        userProfileComponent = new UserProfileComponent(driver);
        PageFactory.initElements(driver, this);
    }

    
    public SignInPageObject goUserSignIn() {
        return userProfileComponent.goSignIn();
    }

    public MailPageObject gotoUserMail() {
        return userProfileComponent.gotoMail();
    }

    public MainPageObject doUserSignOut() {
        return userProfileComponent.signOut();
    }

    public boolean isUserSignedIn() {
        return userProfileComponent.isSignInState();
    }

    public boolean isUserSignedOut() {
        return userProfileComponent.isSignOutState();
    }
    
}
