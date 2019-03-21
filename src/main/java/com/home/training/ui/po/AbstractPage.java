/**
 * @author Pavel Sorokoletov, pavel_sarakaletau@epam.com
 */
package com.home.training.ui.po;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.home.training.ui.constant.TimeConstants;

public abstract class AbstractPage {

    protected WebDriver driver;
    private Wait<WebDriver> waiterFor5sec;

    public abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiterFor5sec = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.ENABLED_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofMillis(TimeConstants.ENABLED_PULLING_MILLIS))
                .ignoring(NoSuchElementException.class);
    }

    protected WebElement waitEnabled(WebElement element) {
        return waiterFor5sec.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitPresent(WebElement element) {
        return waiterFor5sec.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", waitEnabled(element));
        return element;
    }

}
