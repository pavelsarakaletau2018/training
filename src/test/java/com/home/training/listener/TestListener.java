package com.home.training.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void onStart(ITestContext testContext) {
        LOG.info(String.format("=== Start test: %s, class: %s", testContext.getName(),
                testContext.getClass().getCanonicalName()));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        LOG.info("=== Finish test: " + testContext.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("=== Start method: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("+++ Passed method: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("--- Skipped method: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("!!! Failure method: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOG.info("=== Passed with success percentage method: " + result.getName());

    }

}
