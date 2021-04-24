package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddImagePage {
    @FindBy(xpath = "//input[contains(@id,\"tbUEL\")]")
    public WebElement txtImageUrl;

    @FindBy(xpath = "//input[contains(@id,\"tbTitle\")]")
    public WebElement txtTitle;

    @FindBy(xpath = "//input[contains(@id,\"tbDescription\")]")
    public WebElement txtDescription;

    @FindBy(xpath = "//input[contains(@id,\"tbAuthor\")]")
    public WebElement txtAuthor;

    @FindBy(xpath = "//input[contains(@id,\"tbPrice\")]")
    public WebElement txtPrice;

    @FindBy(xpath = "//input[contains(@id,\"tbTags\")]")
    public WebElement txtTags;

    @FindBy(xpath = "//input[contains(@type,\"range\")]")
    public WebElement rangeRating;

    @FindBy(xpath = "//button[contains(@id,\"btnSave\")]")
    public WebElement btnSaveImage;

    @FindBy(xpath = "//input[contains(@id,\"btnReset\")]")
    public WebElement btnResetImage;

    @FindBy(xpath = "//div[contains(@id,\"divMsgOrErr\")]")
    public WebElement tSuccessImageMessage;
}
