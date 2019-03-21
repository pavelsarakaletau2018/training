package com.home.training.ui.wd.drivermanager;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.home.training.ui.wd.constant.DriverType;
import com.home.training.ui.wd.factory.ChromeDriverFactory;
import com.home.training.ui.wd.factory.DriverFactory;
import com.home.training.ui.wd.factory.FirefoxDriverFactory;

public final class DriverManager {
    private static final Logger LOG = LogManager.getLogger();
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver initDriver(String browserType) {
        if (driver != null) {
            LOG.debug("Driver is already initialized: " + driver);
        } else {
            driver = initAndGetDriver(browserType);
            LOG.debug("Provided driver: " + driver);
        }
        return driver;
    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            LOG.warn("Driver was not initialized!");
            throw new IllegalStateException("Driver is not initialized, call initDriver() first.");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            LOG.debug("Driver quit.\n");
        }
    }

    private static WebDriver initAndGetDriver(String browserType) {
        DriverFactory factory = null;
        DriverType driverType = null;
        try {
            driverType = DriverType.valueOf(browserType.toUpperCase(Locale.getDefault()));
            switch (driverType) {
            case CHROME:
                factory = new ChromeDriverFactory();
                break;
            case FIREFOX:
                factory = new FirefoxDriverFactory();
                break;
            default:
                break;
            }
        } catch (IllegalArgumentException e) {
            LOG.error("Illegal browser argument recieved: " + browserType
                    + ", chrome driver will be use as default.");
            factory = new ChromeDriverFactory();
        }
        return DriverConfigurator.getConfiguredDriver(factory.getWebDriver());
    }

}
