package com.griddynamics.qa.vikta.uitesting.sample;

import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * Hooks are blocks of code that can run at various points in the Cucumber execution cycle.
 * They are typically used for setup and teardown of the environment before and after each scenario.
 */
public class Hooks {

    public static WebDriver driver;

    @Before
    public void doBefore() {
        driver = createChromeDriver();
        driver.manage().timeouts().implicitlyWait(DataProvider.get().implicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DataProvider.get().pageLoadTimeout(), TimeUnit.SECONDS);
    }

    @After
    public void doAfter() {
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && Objects.nonNull(driver)) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }

    private ChromeDriver createChromeDriver() {
        // SOme details:  https://github.com/bonigarcia/webdrivermanager/
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--start-maximized");
        ops.addArguments("--dns-prefetch-disable");
        ops.addArguments("test-type");
        ops.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver(ops);
    }
}