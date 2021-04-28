package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Vikta's Login page
 */
public class LoginPage {

    @FindBy(id = "tfLoginname")
    public WebElement txtLoginname;

    @FindBy(id = "tfPassword")
    public WebElement txtPassword;

    @FindBy(id = "btnSubmitLogin")
    public WebElement btnSubmitLogin;

    @FindBy(id = "btnSubmitGoToHome")
    public WebElement btnGoToHome;

    @FindBy(xpath = "//div[@class='login']//p[contains(@style, 'color: #FF1C19')]")
    public WebElement lblError;

    @FindBy(xpath = "//button[@id='btnSubmitGoToRegistration']")
    public WebElement btnSignUp;
}
