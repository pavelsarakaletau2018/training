package com.home.training.ui.po;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.home.training.ui.constant.TimeConstants;

public abstract class AbstractComponent {

    protected WebDriver driver;
    private Wait<WebDriver> fluentWait;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(TimeConstants.ENABLED_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofMillis(TimeConstants.ENABLED_PULLING_MILLIS))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    protected WebElement waitEnabled(WebElement element) {
        return fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitPresent(WebElement element) {
        return fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", waitEnabled(element));
        return element;
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
