package org.vishnu;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.vishnu.config.Configuration;
import org.vishnu.driver.DriverFactory;

import static org.vishnu.config.ConfigurationManager.configuration;

// TODO-  Having trouble running parallel tests using JUNIT but with TestNg we can as of now.

/**
 * Base All to drive the tests using Junit5.
 * BeforeEach would run all methods of a class with new driver instance each time sequentially.
 * Sequential execution can be challenged based on configuration of parallel execution configuration.
 */
@Disabled
// @Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseJunitClass {
    protected WebDriver driver;
    protected Configuration configuration;

    @BeforeAll
    public void preCondition() {
        configuration = configuration();
        driver = new DriverFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
    }

    @AfterAll
    public void postCondition() {
        driver.quit();
    }

    /**
     * Reset to Home page.
     */
    public void resetState() {
        driver.get(configuration().url());
        System.out.println("RESET");
    }
}
