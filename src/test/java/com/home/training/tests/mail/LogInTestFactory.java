package com.home.training.tests.mail;

import org.testng.annotations.Factory;

import com.home.training.ui.wd.constant.DriverType;

public class LogInTestFactory {

    // should be runned separately
    @Factory 
    public Object[] createInstances() {
        int numberOfBrowsers = DriverType.values().length;
        Object[] result = new Object[numberOfBrowsers];
        for (int i = 0; i < result.length; i++) {
            result[i] = new SignInDPTest(DriverType.values()[i].name());
        }
        return result;
    }
    
}
