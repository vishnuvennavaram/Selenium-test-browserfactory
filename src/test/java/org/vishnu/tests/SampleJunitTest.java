package org.vishnu.tests;
import org.junit.jupiter.api.Test;
import org.vishnu.BaseJunitClass;
import org.vishnu.pages.SamplePage;

public class SampleJunitTest extends BaseJunitClass {

    @Test
    void SampleJunitMethod1() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnSoftwareTesting();
        System.out.println("TEST1");
    }

    @Test
    void SampleJunitMethod2() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnQtp();
        System.out.println("TEST2");
    }
}
