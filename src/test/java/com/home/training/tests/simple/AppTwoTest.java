package com.home.training.tests.simple;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AppTwoTest {

    @Epic("Simple self-training test suite")
    @Description("Test with parameters 'name' and 'age'")
    @Feature("Parameterized tests")
    @Link("https://github.com/pavelsarakaletau2018/training")
    @Severity(SeverityLevel.MINOR)
    @Parameters({ "name1", "age1" })
    // automatic convert String to Integer for "age" param
    @Test(groups = { "group1" })
    public void simplyTestFour(String name, Integer age) {
        
        SoftAssert paramTestAssert = new SoftAssert();
        paramTestAssert.assertEquals(name, "Dima");
        paramTestAssert.assertEquals(age, new Integer(26));
        paramTestAssert.assertAll();

    }

}
