package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage  {
    @FindBy(xpath = "//td[@data-kind='street']")
    public WebElement tdStreet;

    @FindBy(xpath = "//td[@data-kind='streetAdditional']")
    public WebElement tdAdditionalStreet;

    @FindBy(xpath = "//td[@data-kind='city']")
    public WebElement tdCity;

    @FindBy(xpath = "//td[@data-kind='region']")
    public WebElement tdRegion;

    @FindBy(xpath = "//td[@data-kind='postal']")
    public WebElement tdPostal;

    @FindBy(xpath = "//td[@data-kind='nickname']")
    public WebElement tdNickname;

}
