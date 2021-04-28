package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Vikta's Registration page
 */
public class RegistrationPage extends BasePage {

    @FindBy(id = "tbLoginName")
    public WebElement tbLoginName;

    @FindBy(id = "tbSurname")
    public WebElement tbSurname;

    @FindBy(id = "tbFirstName")
    public WebElement tbFirstName;

    @FindBy(id = "tbMiddleName")
    public WebElement tbMiddleName;

    @FindBy(id = "tbEmail")
    public WebElement tbEmail;

    @FindBy(id = "tbPassword")
    public WebElement tbPassword;

    @FindBy(id = "btnSubmitGoToHome")
    public WebElement btnGoToHome;

    @FindBy(xpath = "//a[@href='/registration']")
    public WebElement btnGoSignUp;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement btnGoToLoginIn;

    @FindBy(xpath = "//button[@id='btnRegister']")
    public WebElement btnRegisterUser;

    @FindBy(id = "tSuccessMessage")
    public WebElement tSuccessMessage;


}
