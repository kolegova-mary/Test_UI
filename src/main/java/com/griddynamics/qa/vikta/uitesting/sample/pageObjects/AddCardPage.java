package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCardPage {
    @FindBy(xpath = "//input[@id='tbNumber']")
    public WebElement txtCardNumber;

    @FindBy(xpath = "//input[@id='tbCode']")
    public WebElement txtCode;

    @FindBy(xpath = "//input[@id='tbOwner']")
    public WebElement txtOwner;

    @FindBy(xpath = "//input[contains(@id,'tbexpiration')]")
    public WebElement txtDate;

    @FindBy(xpath = "//input[@id='tbNickname']")
    public WebElement txtNickname;

    @FindBy(xpath = "//button[@id='btnSave']")
    public WebElement btnSaveCard;

    @FindBy(xpath = "//input[@id='btnReset']")
    public WebElement btnClearCard;

    @FindBy(xpath = "//div[@id='divMsgOrErr']")
    public WebElement tSuccessOrErrorMessage;
}
