package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage extends BasePage{
    @FindBy(xpath = "//a[@id='aHome']")
    public WebElement btoGoAdminHome;

    @FindBy(xpath = "//a[@id='aAdminHut']")
    public WebElement btoShowHut;

    @FindBy(xpath = "//a[@id='aImages']")
    public WebElement btoShowImages;

    @FindBy(xpath = "//a[@id='aAddImage']")
    public WebElement btoAddImage;

    @FindBy(xpath = "//a[@id='aAddImage']")
    public WebElement btoShowCategories;

    @FindBy(xpath = "//a[@id='aAddCategory']")
    public WebElement btoAddCategory;

    @FindBy(xpath = "//a[@href='/admin/users']")
    public WebElement btoShowUsers;

    @FindBy(xpath = "//a[@id='aAddUser']")
    public WebElement btoAddUser;

    @FindBy(xpath = "//a[@id='aUsersStuff']")
    public WebElement btoShowUsersStuff;

    @FindBy(xpath = "//a[@id='aUsrCards']")
    public WebElement btoShowCards;

    @FindBy(xpath = "//a[@id='aUsrAddCard']")
    public WebElement btoAddCard;
}
