package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsItemPage  {
    @FindBy(xpath = "//a[@id='aAddToCart']")
    public WebElement btnAddToCart;

    @FindBy(xpath = "//span[@id='tMessage']")
    public WebElement tSuccessMessage;

    @FindBy(xpath = "//img[@id='imgCartTop']")
    public WebElement btnCart;
}
