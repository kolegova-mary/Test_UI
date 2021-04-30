package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.CartPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class CartSteps extends BaseSteps {
    public CartSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("user hits purchase")
    public void toPurchase() {
        page().btnPurchase.click();
    }

    @Then("purchase info is displayed")
    public void successPurchase() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        //    assertTrue(page().tSuccessMessage.isDisplayed());
    }

    @When("user hits deliver to and chooses address")
    public void toChooseAddress() {
        page().popAddress.click();
        int cnt = page().addressOptions.size();
        page().addressOptions.get(1 + (int) (Math.random() * (cnt-1))).click();
    }

    @When("user hits to be paid by and chooses card")
    public void toChooseCard() {
        page().popCards.click();
        int cnt = page().cardsOptions.size();
        page().cardsOptions.get(1 + (int) (Math.random() * (cnt-1))).click();
    }

    public String getMessageText() {
        return page().tSuccessMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessMessage;
    }

    private CartPage page() {
        return getPage(CartPage.class);
    }
}
