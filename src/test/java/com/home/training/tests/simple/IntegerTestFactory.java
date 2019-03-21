package com.home.training.tests.simple;

import java.util.Random;

import org.testng.annotations.Factory;

public class IntegerTestFactory {
    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            result[i] = new IntegerTest(rand.nextInt(10));
        }
        return result;
    }

}
