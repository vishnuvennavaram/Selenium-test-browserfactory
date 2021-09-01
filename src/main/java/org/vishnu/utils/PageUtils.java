package org.vishnu.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageUtils {

    private WebDriver driver;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait;
    private static final long TIMEOUT_IN_SEC = 10;

    /**
     * To wait till the element is visible on UI otherwise do not throw exception
     *
     * @param webElement is element to be Visible
     * @return element to support method cascading
     */
    public WebElement waitForElementToBeVisible(WebElement webElement) {
        // Web driver wait will by default ignore the No such element exception
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SEC));
        try {
            return wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (NullPointerException e) {
            return webElement;
        }
    }

    /**
     * click on an element based on Web Element
     *
     * @param webElement is element to be clicked once its clickable
     */
    public void clickElement(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * To click on an element based on locator
     *
     * @param locator is By type of the web element to be clicked once its clickable
     */
    public void clickElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SEC));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
