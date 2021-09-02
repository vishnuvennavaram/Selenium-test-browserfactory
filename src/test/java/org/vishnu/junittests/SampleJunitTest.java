package org.vishnu.junittests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.vishnu.BaseJunitClass;
import org.vishnu.pages.SamplePage;
@Disabled
public class SampleJunitTest extends BaseJunitClass {
    @Test
    void SampleJunitMethod1() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnHomePageLinks("Software Testing");
        System.out.println("Hashcode of webDriver instance = " + driver.hashCode());
        System.out.println("Software Testing in Junit");
    }

    @Test
    void SampleJunitMethod2() {
        SamplePage samplePage = new SamplePage(driver);
        System.out.println("Hashcode of webDriver instance = " + driver.hashCode());
        samplePage.clickOnHomePageLinks("QTP (Quick Test Professional) in Junit");
        System.out.println("QTP");
    }

    @AfterEach
    void resetToHomePage() {
        resetState();
    }
}