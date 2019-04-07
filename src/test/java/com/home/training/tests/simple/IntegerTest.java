package com.home.training.tests.simple;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

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
        checkParam(param);
    }

    @Step("Checking for param: {stepParam}")
    public void checkParam(int stepParam) {
        assertThat(stepParam).as("Parameter from factory").withFailMessage("should not be %d", 1).isNotEqualTo(1);
        // assertNotEquals(1, stepParam, "Param = 1, but must not be equals 1!");
    }

}
