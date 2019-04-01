package com.home.training.tests.simple;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.home.training.annotation.Os;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AppTest {

    @Os(osType = "Android")
    @Epic ("Simple self-training test suite")
    @Description ("Test for annotation transformer")
    @Feature("Android tests")
    @Link ("https://github.com/pavelsarakaletau2018/training")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "group1" })
    public void simplyTestOne() {
        System.err.println("Only for Android test!");
        assertEquals(true, true);
    }
    
    @Epic ("Simple self-training test suite")
    @Description ("Dummy test")
    @Feature("Boolean tests")
    @Link ("https://github.com/pavelsarakaletau2018/training")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(groups = { "group2" }, dependsOnMethods = { "simplyTestTree" })
    public void simplyTestTwo() {
        assertEquals(true, true);
    }

    @Epic ("Simple self-training test suite")
    @Description ("Test with data-provider (3 values)")
    @Link ("https://github.com/pavelsarakaletau2018/training")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(groups = { "group2" }, dataProvider = "testData1")
    public void simplyTestTree(String name, Integer age) {
        assertEquals(true, age != 45);
    }

    @DataProvider(name = "testData1")
    public Object[][] createData1(Method meth) {
        return new Object[][] {
                { "Pavel", new Integer(39) },
                { "Alex", new Integer(30) },
                { "Max", new Integer(46) },
        };
    }

}
