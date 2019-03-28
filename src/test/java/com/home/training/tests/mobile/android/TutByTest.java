package com.home.training.tests.mobile.android;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TutByTest extends BrowserBaseTest {

    @Test
    public void simpleTest() throws InterruptedException {
        driver.navigate().to("https://tut.by");
        Assert.assertEquals(driver.getTitle(), "Белорусский портал TUT.BY. Новости Беларуси и мира");
    }

}
