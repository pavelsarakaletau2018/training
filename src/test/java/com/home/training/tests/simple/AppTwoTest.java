package com.home.training.tests.simple;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class AppTwoTest {

    @Epic("Simple self-training test suite")
    @Description("Test with parameters 'name' and 'age'")
    @Feature("Parameterized tests")
    @Link("https://github.com/pavelsarakaletau2018/training")
    @Severity(SeverityLevel.MINOR)
    @Parameters({ "name1", "age1" })
    // automatic convert String to Integer for "age" param
    @Test(groups = { "group1" })
    public void simplyTestFour(@Optional("Dima") String name, @Optional("26") Integer age) {
        checkName(name);
        checkAge(age);
        // assertThat(name).as("user name").withFailMessage("should be %s", "Dima").isEqualTo("Dima1");
        // assertThat(age).as("user age").withFailMessage("should be %d", 26).isEqualTo(266);

        // SoftAssert paramTestAssert = new SoftAssert();
        // paramTestAssert.assertEquals(name, "Dima");
        // paramTestAssert.assertEquals(age, new Integer(26));
        // paramTestAssert.assertAll();

    }

    @Step("Checking for name: {name}")
    private void checkName(String name) {
        assertThat(name).as("user name").withFailMessage("should be %s", "Dima").isEqualTo("Dima");
    }

    @Step("Checking for age: {age}")
    private void checkAge(Integer age) {
        assertThat(age).as("user age").withFailMessage("should be %d", 26).isEqualTo(266);
    }

}
