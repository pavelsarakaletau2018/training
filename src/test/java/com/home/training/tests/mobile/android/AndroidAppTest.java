package com.home.training.tests.mobile.android;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.home.training.ui.wd.drivermanager.DriverManager;
import com.home.training.ui.wd.drivermanager.MobileDriverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidAppTest  {

    AndroidDriver<AndroidElement> driver;
    
    @Test (description = "Just run google chrome")
    public void simpleChromeTest() throws InterruptedException {
        driver.launchApp();
    }
    
    @SuppressWarnings("unchecked")
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = (AndroidDriver<AndroidElement>) MobileDriverManager.initDriver("android_app");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }
    
}
