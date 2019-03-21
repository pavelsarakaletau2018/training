package com.home.training.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.home.training.annotation.Os;

public class AnnotationTranformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
            Method testMethod) {
        if (testMethod.isAnnotationPresent(Os.class)) {
            Os myAnno = testMethod.getAnnotation(Os.class);
            if ("android".equalsIgnoreCase(myAnno.osType())) {
                annotation.setEnabled(true);
            }
        }

    }

}
