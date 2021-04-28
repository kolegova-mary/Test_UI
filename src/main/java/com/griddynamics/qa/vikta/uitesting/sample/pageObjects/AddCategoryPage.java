package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCategoryPage {
    @FindBy(xpath = "//input[@id='tbTitle']")
    public WebElement txtTitle;

    @FindBy(xpath = "//input[@id='tbDescription']")
    public WebElement txtDescription;

    @FindBy(xpath = "//input[@id='tbPathToCatImage']")
    public WebElement txtPath;

    @FindBy(xpath = "//button[@id='btnSave']")
    public WebElement bToSave;

    @FindBy(xpath = "//input[@id='btnReset']")
    public WebElement bToReset;

    @FindBy(xpath = "//div[@id='divMsgOrErr']")
    public WebElement tSuccessOrErrorMessage;

}
