package org.vishnu.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.vishnu.BaseClass;
import org.vishnu.pages.SamplePage;

public class SampleTest extends BaseClass {

    @Test
    void SampleTestNgMethod() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnHomePageLinks("Software Testing");
        System.out.println("Hashcode of webDriver instance = " + driver.hashCode());
        System.out.println("Software Testing");
    }

    @Test
    void SampleTestNgMethod2() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnHomePageLinks("QTP");
        System.out.println("Hashcode of webDriver instance = " + driver.hashCode());
        System.out.println("QTP");
    }

    @AfterMethod
    void resetToHomePage() {
        resetState();
    }
}
