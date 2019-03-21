package com.home.training.tests.wd;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.home.training.ui.wd.drivermanager.DriverManager;

public class WebDriverTest {
    WebDriver driver;

    @Test
    public void getWebDriverTest() {
        driver = DriverManager.initDriver("firefox");
        driver.navigate().to("https://onliner.by");
        System.out.println(driver.getTitle());
        assertNotEquals(driver.getTitle(), "");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}
