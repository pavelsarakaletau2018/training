package com.home.training.ui.wd.constant;

public final class DriverConstants {

    // Selenium webdriver UI test values
    public static final String WD_BROWSER_DEFAULT = "chrome";
    public static final boolean WD_LOG_DEFAULT = false;
    public static final String SYSTEM_VAR_CHROME = "webdriver.chrome.driver";
    public static final String SYSTEM_VAR_FIREFOX = "webdriver.gecko.driver";

    // Mobile driver values
    public static final String PLATFORM_DEFAULT = "Android";
//    public static final String PLATFORM_VERSION_DEFAULT = "7.0";
    public static final String PLATFORM_VERSION_DEFAULT = "6.0.1";
    public static final String DEVICE_NAME = "LG-H870DS";
    public static final String MOBILE_BROWSER = "chrome";
    public static final String CAP_PLATFORM_VERSION = "platformVersion";
    public static final String CAP_DEVICE_NAME = "deviceName";
    public static final String CAP_APP = "app";
    public static final String CAP_APP_PACKAGE = "appPackage";
    public static final String CAP_APP_ACTIVITY = "appActivity";
    public static final String CAP_UNICODE = "unicodeKeyboard";
    public static final String CAP_RESET_KEYBOARD = "resetKeyboard";
    public static final String CAP_NO_RESET = "noReset";
    public static final String CAP_AUTO_GRANT_PERM = "autoGrantPermissions";

    private DriverConstants() {
    }

}
