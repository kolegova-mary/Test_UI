package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAddressPage {
    @FindBy(xpath = "//input[contains(@placeholder,'Street')]")
    public WebElement txtStreet;

    @FindBy(xpath = "//input[contains(@placeholder,'Additional')]")
    public WebElement txtAdditionalStreetInfo;

    @FindBy(xpath = "//input[contains(@id,'tbCity')]")
    public WebElement txtCity;

    @FindBy(xpath = "//input[contains(@id,'tbRegion')]")
    public WebElement txtRegion;

    @FindBy(xpath = "//input[contains(@id,'tbPostal')]")
    public WebElement txtPostalCode;

    @FindBy(xpath = "//input[contains(@id,'tbAddress')]")
    public WebElement txtAddressNickname;

    @FindBy(xpath = "//button[@id='btnSave']")
    public WebElement btnSave;

    @FindBy(xpath = "//input[@id='btnReset']")
    public WebElement btnReset;

    @FindBy(xpath = "//div[@id='divMsgOrErr']")
    public WebElement tSuccessOrErrorMessage;
}
