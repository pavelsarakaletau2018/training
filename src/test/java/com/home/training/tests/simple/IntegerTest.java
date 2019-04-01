package com.home.training.tests.simple;

import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class IntegerTest {
    private int param;

    IntegerTest(int param) {
        super();
        this.param = param;
    }

    @Epic("Simple self-training test suite - run via factory")
    @Description("Test for running with factory")
    @Feature("Integer tests")
    @Link("https://github.com/pavelsarakaletau2018/training")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testIntegerValue() {
        assertNotEquals(1, param, "Param is 1!");
    }

}
