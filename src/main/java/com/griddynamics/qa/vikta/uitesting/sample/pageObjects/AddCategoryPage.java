package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCategoryPage {
    @FindBy(xpath = "//input[contains(@id,\"tbTitle\")]")
    public WebElement txtTitle;

    @FindBy(xpath = "//input[contains(@id,\"tbDescription\")]")
    public WebElement txtDescription;

    @FindBy(xpath = "//input[contains(@id,\"tbPathToCatImage\")]")
    public WebElement txtPath;

    @FindBy(xpath = "//button[contains(@id,\"btnSave\")]")
    public WebElement bToSave;

    @FindBy(xpath = "//input[contains(@id,\"btnReset\")]")
    public WebElement bToReset;

    @FindBy(xpath = "//div[contains(@id,\"divMsgOrErr\")]")
    public WebElement tSuccessOrErrorMessage;

}
