package com.home.training.tests.simple;

import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

public class IntegerTest {
    private int param;

    IntegerTest(int param) {
        super();
        this.param = param;
    }

    @Test
    public void testIntegerValue() {
        // System.err.println("Param: " + param);
        assertNotEquals(1, param, "Param is 1!");
    }

}
