package com.home.training.ui.wd.factory;

import java.util.ResourceBundle;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.home.training.ui.wd.constant.DriverConstants;
import com.home.training.ui.constant.PropertyConstants;

public class ChromeDriverFactory implements DriverFactory {
    private static final Logger LOG = LogManager.getLogger();

    private static ResourceBundle bundle = ResourceBundle.getBundle(PropertyConstants.WD_BASENAME);

    @Override
    public WebDriver getWebDriver() {

        if (null == System.getenv(DriverConstants.SYSTEM_VAR_CHROME)) {
            // LOG.log(Level.ERROR, "Failed to get system property for chrome driver");
            System.setProperty(DriverConstants.SYSTEM_VAR_CHROME,
                    bundle.getString(PropertyConstants.CHROME_PATH_PROP));
        } else {
            System.setProperty(DriverConstants.SYSTEM_VAR_CHROME,
                    System.getenv(DriverConstants.SYSTEM_VAR_CHROME));
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return new ChromeDriver(options);
    }

}
