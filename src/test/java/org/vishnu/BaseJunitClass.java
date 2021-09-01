package org.vishnu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.vishnu.config.Configuration;
import org.vishnu.driver.DriverFactory;

import static org.vishnu.config.ConfigurationManager.configuration;

/**
 * Base All to drive the tests using Junit5.
 * BeforeEach would run all methods of a class with new driver instance each time sequentially.
 * Sequential execution can be challenged based on configuration of parallel execution configuration.
 */
public class BaseJunitClass {
    protected WebDriver driver;
    protected Configuration configuration;

    @BeforeEach
    public void preCondition() {
        configuration = configuration();

        driver = new DriverFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }
}
