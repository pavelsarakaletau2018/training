package com.home.training.tests.mobile.android;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.home.training.ui.wd.drivermanager.DriverManager;
import com.home.training.ui.wd.drivermanager.MobileDriverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppBaseTest {
AndroidDriver<AndroidElement> driver;
    
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
