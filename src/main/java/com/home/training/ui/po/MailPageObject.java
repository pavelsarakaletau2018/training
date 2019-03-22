package com.home.training.ui.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MailPageObject extends AbstractPage {
    private static final Logger LOG = LogManager.getLogger();

    private static final String BASE_URL = "https://mail.yahoo.com";

    @FindBy(xpath = "//input[@id = 'ybarAccountMenu']/..")
    @CacheLookup
    private WebElement accountMenu;

    @FindBy(xpath = "//*[@id='ybarAccountMenuBody']/a[3]")
    @CacheLookup
    private WebElement accountMenuSignOut;

    public MailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MailPageObject openPage() {
        LOG.info("Opening page...");
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainPageObject signOut() {
        LOG.info("Sign out...");
        // using Actions to perform task goal
        Actions act = new Actions(driver);
        act.click(accountMenu).click(accountMenuSignOut).perform();
        return new MainPageObject(driver);
    }

}
