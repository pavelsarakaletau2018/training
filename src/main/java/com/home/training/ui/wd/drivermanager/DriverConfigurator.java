package com.home.training.ui.wd.drivermanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.home.training.ui.constant.TimeConstants;

public final class DriverConfigurator {

    private DriverConfigurator() {
    }

    public static WebDriver getConfiguredDriver(WebDriver driver) {

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TimeConstants.PAGE_LOAD_TIMEOUT,
                TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(TimeConstants.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
        // driver.manage().timeouts().implicitlyWait(TimeConstants.IMPLICITLY_TIMEOUT,
        // TimeUnit.SECONDS);
        // driver.manage().window().maximize();

        return driver;
    }

}
