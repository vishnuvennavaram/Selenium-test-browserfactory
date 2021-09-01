package org.vishnu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.vishnu.config.Configuration;
import org.vishnu.driver.DriverFactory;

import static org.vishnu.config.ConfigurationManager.configuration;

/**
 * Base class to drive the tests using Junit5.
 * BeforeEach will run all methods of a each class with same driver instance sequentially
 * BeforeMethod would run all methods of a class with new driver instance each time sequentially.
 * Sequential execution can be challenged based on configuration of parallel execution configuration.
 */
public class BaseJunitClass {
    protected WebDriver driver;
    protected Configuration configuration;

    @BeforeEach
    //@BeforeClass
    public void preCondition() {
        configuration = configuration();

        driver = new DriverFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
    }

    @AfterEach
    //@AfterClass
    public void postCondition() {
        driver.quit();
    }
}
