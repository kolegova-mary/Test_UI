package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {
    @FindBy(xpath = "//input[@id='tbLoginName']")
    public WebElement txtLoginName;

    @FindBy(xpath = "//input[@id='tbPassword']")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[@id='tbEmail']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@id='tbSurname']")
    public WebElement txtSurname;

    @FindBy(xpath = "//input[@id='tbFirstName']")
    public WebElement txtName;

    @FindBy(xpath = "//input[@id='tbMiddleName']")
    public WebElement txtMiddleName;

    @FindBy(xpath = "//button[@id='btnSave']")
    public WebElement btnSaveUser;

    @FindBy(xpath = "//input[@id='btnReset']")
    public WebElement btnClearItOut;

    @FindBy(xpath = "//div[contains(@id,'divMsgOrErr')]")
    public WebElement tSuccessMessage;
}
