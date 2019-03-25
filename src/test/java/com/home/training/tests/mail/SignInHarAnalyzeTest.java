package com.home.training.tests.mail;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.home.training.ui.po.MainPageObject;
import com.home.training.ui.po.SignInPageObject;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarRequest;
import proxy.bmp.ActionRecorder;
import proxy.bmp.ulil.HarAnalyzer;

public class SignInHarAnalyzeTest extends BaseTest {
    private static final String NAME = "pavel.sarakaletau@yahoo.com";
    private static final String PASSWORD = "testpassword2";
    private static final String URL_PATTERN = "geo.yahoo.com";
    private MainPageObject mainPage;

    @BeforeMethod(alwaysRun = true)
    public void doPrepare() {
        mainPage = new MainPageObject(driver);
        mainPage.openPage();
    }

    @Test(groups = { "signin" }, description = "Perform sign in operation and check the result.")
    public void signInTest() {

        ActionRecorder rec = new ActionRecorder();
        SignInPageObject signInPage = mainPage.goUserSignIn();
        rec.startRecord("User sign in");
        signInPage.setUserName(NAME).goNext().setPassword(PASSWORD);
        signInPage.goNext();
        rec.stopRecord().saveHarFile();

        Har harResult = rec.getHarFile();
        List<HarRequest> harRequest = HarAnalyzer.getRequestsByUrl(harResult, URL_PATTERN);

        SoftAssert harAnalysisAssert = new SoftAssert();
        harAnalysisAssert.assertNotEquals(harResult, null, "Result har object is NULL!");
        harAnalysisAssert.assertNotEquals(harRequest, null, "Analysis result list is NULL!");
        harRequest.forEach(r -> {
            harAnalysisAssert.assertTrue(r.getUrl().contains(URL_PATTERN),
                    String.format("Result request [%s] doesn't match pattern [%s]", r.getUrl(), URL_PATTERN));
        });
        harAnalysisAssert.assertAll();
    }

}
