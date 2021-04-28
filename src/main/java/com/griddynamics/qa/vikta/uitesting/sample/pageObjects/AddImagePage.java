package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddImagePage {
    @FindBy(xpath = "//input[@id='tbUEL']")
    public WebElement txtImageUrl;

    @FindBy(xpath = "//input[@id='tbTitle']")
    public WebElement txtTitle;

    @FindBy(xpath = "//input[@id='tbDescription']")
    public WebElement txtDescription;

    @FindBy(xpath = "//input[@id='tbAuthor']")
    public WebElement txtAuthor;

    @FindBy(xpath = "//input[@id='tbPrice']")
    public WebElement txtPrice;

    @FindBy(xpath = "//input[@id='tbTags']")
    public WebElement txtTags;

    @FindBy(xpath = "//button[@id='btnSave']")
    public WebElement btnSaveImage;

    @FindBy(xpath = "//input[@id='btnReset']")
    public WebElement btnResetImage;

    @FindBy(xpath = "//div[@id='divMsgOrErr']")
    public WebElement tSuccessImageMessage;
}
