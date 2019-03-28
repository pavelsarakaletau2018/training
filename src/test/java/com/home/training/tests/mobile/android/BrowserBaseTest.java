package com.home.training.tests.mobile.android;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.home.training.ui.wd.drivermanager.DriverManager;
import com.home.training.ui.wd.drivermanager.MobileDriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BrowserBaseTest {
    AppiumDriver<MobileElement> driver;

    @SuppressWarnings("unchecked")
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver =  (AppiumDriver<MobileElement>) MobileDriverManager.initDriver("android_chrome");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }

}
