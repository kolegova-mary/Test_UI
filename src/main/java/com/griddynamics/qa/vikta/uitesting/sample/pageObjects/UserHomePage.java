package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHomePage {
    @FindBy(xpath = "//a[@id='aAddresses']")
    public WebElement btnAddresses;

    @FindBy(xpath = "//a[@id='aAddAddress']")
    public WebElement btnToAddAddress;

    @FindBy(xpath = "//a[@id='aCards']")
    public WebElement btnCards;

    @FindBy(xpath = "//a[@id='aAddCard']")
    public WebElement btnToAddCard;

    @FindBy(xpath = "//span[@id='sploggedInName']")
    public WebElement txtUserName;
}
