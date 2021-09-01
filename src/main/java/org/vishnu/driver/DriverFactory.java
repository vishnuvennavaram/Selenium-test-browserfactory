package org.vishnu.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.vishnu.exceptions.TargetNotValidException;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.vishnu.config.ConfigurationManager.configuration;

/**
 * This class does the orchestration of the driver based on LOCAL OR REMOTE.
 */
public class DriverFactory {

    private static final Logger logger = Logger.getLogger("com.vishnu");

    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(configuration().target().toUpperCase());
        WebDriver webdriver;

        switch (target) {
            case LOCAL:
                webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
                break;
            case REMOTE:
                webdriver = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return webdriver;
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", configuration().gridUrl(), configuration().gridPort());

            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capability);
        } catch (java.net.MalformedURLException e) {
            logger.log(Level.SEVERE, "Grid URL is invalid or Grid is not available");
            logger.log(Level.SEVERE, String.format("Browser: %s", capability.getBrowserName()), e);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, String.format("Browser %s is not valid or recognized", capability.getBrowserName()), e);
        }

        return remoteWebDriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}

