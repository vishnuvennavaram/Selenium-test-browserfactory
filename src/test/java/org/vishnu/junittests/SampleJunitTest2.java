package org.vishnu.junittests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.vishnu.BaseJunitClass;
import org.vishnu.pages.SamplePage;
@Disabled
public class SampleJunitTest2 extends BaseJunitClass {

    @Test
    void SampleJunitMethod1() {
        SamplePage samplePage = new SamplePage(driver);
        samplePage.clickOnHomePageLinks("Cucumber Testing");
        System.out.println("Hashcode of webDriver instance = " + driver.hashCode());
        System.out.println("Cucumber in Junit");
    }
}
