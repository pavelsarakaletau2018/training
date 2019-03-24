package com.home.training.ui.wd.factory;

import java.util.ResourceBundle;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.home.training.ui.constant.PropertyConstants;
import com.home.training.ui.constant.SystemConstants;
import com.home.training.ui.wd.constant.DriverConstants;

import proxy.ProxyHandler;

public class FirefoxDriverFactory implements DriverFactory {
    private static final Logger LOG = LogManager.getLogger("DM");

    private static ResourceBundle bundle = ResourceBundle.getBundle(PropertyConstants.WD_BASENAME);

    @Override
    public WebDriver getWebDriver() {
        if (null == System.getenv(DriverConstants.SYSTEM_VAR_FIREFOX)) {
            LOG.error("Failed to get system property for gecko.driver");
            System.setProperty(DriverConstants.SYSTEM_VAR_FIREFOX,
                    bundle.getString(PropertyConstants.FIREFOX_PATH_PROP));
        } else {
            System.setProperty(DriverConstants.SYSTEM_VAR_FIREFOX,
                    System.getenv(DriverConstants.SYSTEM_VAR_FIREFOX));
        }

        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(FirefoxDriverLogLevel.ERROR);
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        String pageLoadStrategy = (null != System.getProperty(SystemConstants.SYS_PROP_FOX_STRATEGY)
                ? System.getProperty(SystemConstants.SYS_PROP_FOX_STRATEGY)
                : "normal");
        options.setPageLoadStrategy(PageLoadStrategy.valueOf(pageLoadStrategy.toUpperCase()));

        if (Boolean.parseBoolean(System.getProperty(SystemConstants.SYS_PROP_PROXY))) {
            LOG.log(Level.DEBUG, "Setting a proxy.");
            options.setProxy(ProxyHandler.INSTANCE.getSeleniumProxy());
        }
        return new FirefoxDriver(options);
    }
}
