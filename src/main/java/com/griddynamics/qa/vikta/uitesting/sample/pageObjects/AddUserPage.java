package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {
    @FindBy(xpath = "//input[contains(@id,\"tbLoginName\")]")
    public WebElement txtLoginName;

    @FindBy(xpath = "//input[contains(@id,\"tbPassword\")]")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[contains(@id,\"tbEmail\")]")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[contains(@id,\"tbSurname\")]")
    public WebElement txtSurname;

    @FindBy(xpath = "//input[contains(@id,\"tbFirstName\")]")
    public WebElement txtName;

    @FindBy(xpath = "//input[contains(@id,\"tbMiddleName\")]")
    public WebElement txtMiddleName;

    @FindBy(xpath = "//button[contains(@id,\"btnSave\")]")
    public WebElement btnSaveUser;

    @FindBy(xpath = "//input[contains(@id,\"btnReset\")]")
    public WebElement btnClearItOut;

    @FindBy(xpath = "//div[contains(@id,\"divMsgOrErr\")]")
    public WebElement tSuccessMessage;
}
