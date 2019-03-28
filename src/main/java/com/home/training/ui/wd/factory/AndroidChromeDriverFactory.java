package com.home.training.ui.wd.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.home.training.ui.constant.PropertyConstants;
import com.home.training.ui.wd.constant.DriverConstants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidChromeDriverFactory implements DriverFactory {
    private static final Logger LOG = LogManager.getLogger("DM");
    private static ResourceBundle bundle = ResourceBundle.getBundle(PropertyConstants.WD_BASENAME);
    private WebDriver driver;

    @Override
    public WebDriver getWebDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
                DriverConstants.PLATFORM_DEFAULT);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DriverConstants.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, DriverConstants.PLATFORM_VERSION_DEFAULT);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, DriverConstants.MOBILE_BROWSER);

        try {
            driver = new AndroidDriver<AndroidElement>(new URL(bundle
                    .getString(PropertyConstants.APPIUM_URL_PROP)), capabilities);
        } catch (MalformedURLException e1) {
            LOG.error("Incorrect Appium URL!", e1);
        } catch (org.openqa.selenium.WebDriverException e2) {
            LOG.error("Error connection to Appium URL!", e2);
        }
        return driver;
    }
}
