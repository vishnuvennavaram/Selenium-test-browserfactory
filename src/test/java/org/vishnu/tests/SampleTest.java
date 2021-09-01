package org.vishnu.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.vishnu.BaseClass;
import org.vishnu.pages.SamplePage;

public class SampleTest extends BaseClass {

    @Test
    void SampleTestNgMethod() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnSoftwareTesting();
        System.out.println("TEST1");
    }

    @Test
    void SampleTestNgMethod2() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnQtp();
        System.out.println("TEST2");
    }

    @AfterMethod
    void resetToHomePage() {
        resetState();
    }
}
