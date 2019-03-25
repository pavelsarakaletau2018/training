package com.home.training.tests.mail;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.home.training.constant.SystemConstants;
import com.home.training.ui.wd.drivermanager.DriverManager;

public class BaseTest {
    WebDriver driver;

    @Parameters({ "browser" })
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserSuiteParam) {
        String browserName = (null == System.getProperty(SystemConstants.SYS_PROP_BROWSER))
                ? browserSuiteParam
                : System.getProperty(SystemConstants.SYS_PROP_BROWSER);
        driver = DriverManager.initDriver(browserName);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }

}
