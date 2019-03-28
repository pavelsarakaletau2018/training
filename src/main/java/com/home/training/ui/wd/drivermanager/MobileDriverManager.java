package com.home.training.ui.wd.drivermanager;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.home.training.ui.wd.constant.MobileDriverType;
import com.home.training.ui.wd.factory.AndroidAppDriverFactory;
import com.home.training.ui.wd.factory.AndroidChromeDriverFactory;
import com.home.training.ui.wd.factory.DriverFactory;

public final class MobileDriverManager {
    private static final Logger LOG = LogManager.getLogger("DM");
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    private MobileDriverManager() {
    }

    public static WebDriver initDriver(String browserType) {
        if (driverLocal.get() != null) {
            LOG.debug("Driver is already initialized: " + driverLocal.get());
        } else {
            driverLocal.set(initAndGetDriver(browserType));
            LOG.debug("Provided driver: " + driverLocal.get());
        }
        return driverLocal.get();
    }

    public static WebDriver getDriverInstance() {
        if (driverLocal.get() == null) {
            LOG.warn("Driver was not initialized!");
            throw new IllegalStateException("Driver is not initialized, call initDriver() first.");
        }
        return driverLocal.get();
    }

    public static void closeDriver() {
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
            driverLocal.set(null);
            LOG.debug("Driver quit.\n");
        }
    }

    private static WebDriver initAndGetDriver(String browserType) {
        DriverFactory factory = null;
        MobileDriverType driverType = null;
        try {
            driverType = MobileDriverType.valueOf(browserType.toUpperCase(Locale.getDefault()));
            switch (driverType) {
            case ANDROID_CHROME:
                factory = new AndroidChromeDriverFactory();
                break;
            case ANDROID_APP:
                factory = new AndroidAppDriverFactory();
                break;
            default:
                break;
            }
        } catch (IllegalArgumentException e) {
            LOG.error("Illegal browser argument recieved: " + browserType
                    + ", android chrome driver will be use as default.");
            factory = new AndroidChromeDriverFactory();
        }
        return factory.getWebDriver();
    }

}
