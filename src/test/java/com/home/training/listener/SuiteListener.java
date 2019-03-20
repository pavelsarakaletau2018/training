package com.home.training.listener;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.TestListenerAdapter;

public class SuiteListener extends TestListenerAdapter implements ISuiteListener {
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void onStart(ISuite suite) {
        LOG.info("<<<<<<< SUITE START: " + suite.getName() + " >>>>>>>\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        LOG.info("<<<<<<< SUITE FINISH: " + suite.getName() + " with timing:");
        List<IInvokedMethod> invoked = suite.getAllInvokedMethods();
        invoked.forEach(m -> {
            String name = m.getTestMethod().getMethodName();
            Long time = m.getTestResult().getEndMillis() - m.getTestResult().getStartMillis();
            LOG.info(String.format("%s, run time: %d ms", name, time));
        });
    }

}
