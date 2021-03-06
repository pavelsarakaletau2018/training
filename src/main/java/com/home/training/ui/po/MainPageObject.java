package com.home.training.ui.po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObject extends AbstractPage {
    
    private static final Logger LOG = LogManager.getLogger();
    private static final String BASE_URL = "https://yahoo.com/";

    @FindBy(css = "a[href='https://news.yahoo.com/']")
    private WebElement gotoNews;
    
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

    public NewsPageObject goToNews() {
        waitEnabled(gotoNews).click();
        return new NewsPageObject(driver);
    }
    
}
