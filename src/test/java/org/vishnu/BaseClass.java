package org.vishnu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.vishnu.config.Configuration;
import org.vishnu.driver.DriverFactory;

import static org.vishnu.config.ConfigurationManager.configuration;

/**
 * Base class to drive the tests using TestNg.
 * BeforeTest will run all methods of a each class with same driver instance sequentially
 * BeforeMethod would run all methods of a class with new driver instance each time sequentially.
 * Sequential execution can be challenged based on configuration of parallel execution configuration.
 */
public class BaseClass {
    protected WebDriver driver;
    protected Configuration configuration;

    //@BeforeMethod
    @BeforeTest
    public void preCondition() {
        configuration = configuration();

        driver = new DriverFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
    }

    //AfterMethod
    @AfterTest
    public void postCondition() {
        driver.quit();
    }
}
