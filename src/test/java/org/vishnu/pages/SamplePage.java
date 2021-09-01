package org.vishnu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.vishnu.utils.PageUtils;

public class SamplePage {
    PageUtils pageUtils;
    private final By softwareTestingLink = By.partialLinkText("Software Testing");

    public SamplePage(WebDriver driver) {
        pageUtils = new PageUtils(driver);
    }

    public void clickOnSoftwareTesting() {
        pageUtils.clickElement(softwareTestingLink);
    }
}
