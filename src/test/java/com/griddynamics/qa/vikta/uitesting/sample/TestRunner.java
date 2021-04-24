package com.griddynamics.qa.vikta.uitesting.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Runner class that uses the Cucumber JUnit runner
 * The @CucumberOptions can be used to provide additional configuration to the runner.
 */
@RunWith(Cucumber.class)
// NOTE: Let Cucumber generate reports of several kinds.
@CucumberOptions( plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
        "html:target/cucumber-reports"},
        monochrome = true)
public class TestRunner {
}