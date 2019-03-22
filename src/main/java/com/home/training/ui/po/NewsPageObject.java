package com.home.training.ui.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPageObject extends AbstractPage {

    private static final Logger LOG = LogManager.getLogger();
    private static final String BASE_URL = "https://news.yahoo.com/";

    @FindBy(css = "a[href='https://yahoo.com/']")
    private WebElement gotoMain;

    public NewsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public NewsPageObject openPage() {
        LOG.info("Opening page: " + BASE_URL);
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainPageObject goToNews() {
        waitEnabled(gotoMain).click();
        return new MainPageObject(driver);
    }

}
