package org.vishnu.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.vishnu.BaseClass;
import org.vishnu.pages.SamplePage;

public class SampleTest2 extends BaseClass {

    @Test
    void SampleTestNgMethod() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnHomePageLinks("Cucumber Testing");
        System.out.println("Hashcode of webDriver instance = " + driver.hashCode());
        System.out.println("Cucumber Testing");
    }

    @AfterMethod
    void resetToHomePage() {
        resetState();
    }
}
