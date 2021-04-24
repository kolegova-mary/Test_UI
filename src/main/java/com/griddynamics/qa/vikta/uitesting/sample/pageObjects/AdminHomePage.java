package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage extends BasePage{
    @FindBy(xpath = "//a[contains(@id,\"aHome\")]")
    public WebElement btoGoAdminHome;

    @FindBy(xpath = "//a[contains(@id,\"aAdminHut\")]")
    public WebElement btoShowHut;

    @FindBy(xpath = "//a[contains(@id,\"aImages\")]")
    public WebElement btoShowImages;

    @FindBy(xpath = "//a[contains(@id,\"aAddImage\")]")
    public WebElement btoAddImage;

    @FindBy(xpath = "//a[contains(@id,\"aAddImage\")]")
    public WebElement btoShowCategories;

    @FindBy(xpath = "//a[contains(@id,\"aAddCategory\")]")
    public WebElement btoAddCategory;

    @FindBy(xpath = "//a[contains(@href,\"/admin/users\")]")
    public WebElement btoShowUsers;

    @FindBy(xpath = "//a[contains(@id,\"aAddUser\")]")
    public WebElement btoAddUser;

    @FindBy(xpath = "//a[contains(@id,\"aUsersStuff\")]")
    public WebElement btoShowUsersStuff;

    @FindBy(xpath = "//a[contains(@id,\"aUsrCards\")]")
    public WebElement btoShowCards;

    @FindBy(xpath = "//a[contains(@id,\"aUsrAddCard\")]")
    public WebElement btoAddCard;
}
