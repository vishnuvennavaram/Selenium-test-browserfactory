package org.vishnu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.vishnu.config.Configuration;
import org.vishnu.driver.DriverFactory;

import static org.vishnu.config.ConfigurationManager.configuration;

/**
 * Base class to drive the tests using TestNg.
 * BeforeClass will run all methods of a each class with same driver instance sequentially
 * BeforeMethod would run all methods of a class with new driver instance each time sequentially.
 * Sequential execution can be challenged based on configuration of parallel execution configuration.
 */
public class BaseClass {
    protected WebDriver driver;
    protected Configuration configuration;

    //@BeforeMethod
    @BeforeClass
    public void preCondition() {
        configuration = configuration();

        driver = new DriverFactory().createInstance(configuration().browser());
        driver.get(configuration().url());
    }

    /**
     * Reset to Home page.
     */
    public void resetState() {
        driver.get(configuration().url());
        System.out.println("RESET");
    }

    //@AfterMethod
    @AfterClass
    public void postCondition() {
        driver.quit();
    }
}

/*
BeforeSuite
'   BeforeTest
'   '   BeforeClass
'   '   '   BeforeMethod
'   '   '   '   myTestMethod3
'   '   '   AfterMethod
'   '   '   BeforeMethod
'   '   '   '   myTestMethod4
'   '   '   AfterMethod
'   '   AfterClass
'   AfterTest
'   BeforeTest
'   '   BeforeClass
'   '   '   BeforeMethod
'   '   '   '   myTestMethod1
'   '   '   AfterMethod
'   '   '   BeforeMethod
'   '   '   '   myTestMethod2
'   '   '   AfterMethod
'   '   AfterClass
'   '   BeforeClass
'   '   '   BeforeMethod
'   '   '   '   myTestMethod3
'   '   '   AfterMethod
'   '   '   BeforeMethod
'   '   '   '   myTestMethod4
'   '   '   AfterMethod
'   '   AfterClass
'   AfterTest
AfterSuite
 */