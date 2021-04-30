package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage  {
    @FindBy(xpath = "//input[@id='btnPurchase']")
    public WebElement btnPurchase;

    @FindBy(xpath = "//select[@id='slctAddress']/option")
    public List<WebElement> addressOptions;

    @FindBy(xpath = "//select[@id='slctPayment']/option")
    public List<WebElement> cardsOptions;

    @FindBy(xpath = "//select[@id='slctAddress']")
    public WebElement popAddress;

    @FindBy(xpath = "//select[@id='slctPayment']")
    public WebElement popCards;

    @FindBy(xpath = "//div[@id='divUponPurchase']")
    public WebElement tSuccessMessage;


}
