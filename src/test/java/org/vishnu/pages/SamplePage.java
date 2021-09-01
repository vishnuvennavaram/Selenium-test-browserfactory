package org.vishnu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.vishnu.utils.PageUtils;

public class SamplePage {
    PageUtils pageUtils;
    private final By softwareTestingLink = By.partialLinkText("Software Testing");
    private final By qtp = By.partialLinkText("QTP (Quick Test Professional)");

    public SamplePage(WebDriver driver) {
        pageUtils = new PageUtils(driver);
    }

    public void clickOnSoftwareTesting() {
        pageUtils.clickElement(softwareTestingLink);
    }

    public void clickOnQtp() {
        pageUtils.clickElement(qtp);
    }
}
