package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardsPage  {
    @FindBy(xpath = "//td[@data-kind='number']")
    public WebElement tdNumber;

    @FindBy(xpath = "//td[@data-kind='code']")
    public WebElement tdCode;

    @FindBy(xpath = "//td[@data-kind='owner']")
    public WebElement tdOwner;

    @FindBy(xpath = "//td[@data-kind='expiration']")
    public WebElement tdExpiration;

    @FindBy(xpath = "//td[@data-kind='tag']")
    public WebElement tdTags;
}
