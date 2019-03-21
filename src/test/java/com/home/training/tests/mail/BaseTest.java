package com.home.training.tests.mail;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.home.training.ui.wd.drivermanager.DriverManager;

public class BaseTest {
    WebDriver driver;

    @Parameters({ "browser" })
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverManager.initDriver(browser);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }

}
