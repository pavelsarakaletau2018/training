package com.home.training.tests.simple;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.home.training.annotation.Os;

public class AppTest {

    @Os(osType = "Android")
    @Test(enabled = false, groups = { "group1" })
    public void simplyTestOne() {
        System.err.println("Only for Android test!");
        assertEquals(true, true);
    }

    @Test(groups = { "group2" }, dependsOnMethods = { "simplyTestTree" })
    public void simplyTestTwo() {
        assertEquals(true, true);
    }

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
