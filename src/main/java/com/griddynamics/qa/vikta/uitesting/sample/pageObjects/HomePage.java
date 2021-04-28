package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Home page
 */
public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@id='aHome']")
    public WebElement bToGoHome;

    @FindBy(xpath = "//a[@id='aRegistration']")
    public WebElement bToSignUp;

    @FindBy(xpath = "//a[@id='aLogin']")
    public WebElement bToLogIn;
}