package com.home.training.tests.simple;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTwoTest {

    @Parameters({ "name1", "age1" })
    // automatic String to Integer for "age"
    @Test(groups = { "group1" })
    public void simplyTestFoure(String name, Integer age) {
//        System.out.println(String.format("Name: %s, Age: %d", name, age));
        assertEquals(true, true);

    }

}
