package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.DetailsItemPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class DetailsImageSteps extends BaseSteps {
    private static String SUCCESSFUL_ITEM_MESSAGE_PREFIX = "Added to cart. Cart size(qty of unique items): ";

    public DetailsImageSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("user hits add to cart")
    public void toAddCart() {
        page().btnAddToCart.click();
    }

    @When("user hits cart")
    public void toCart() {
        page().btnCart.click();
    }

    @Then("Successful item message is displayed")
    public void verifySuccessfulItemMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful add item message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_ITEM_MESSAGE_PREFIX);
    }

    @Then("cart is visible for user")
    public void verifyCartIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(page().btnCart));
    }

    public String getMessageText() {
        return page().tSuccessMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessMessage;
    }


    private DetailsItemPage page() {
        return getPage(DetailsItemPage.class);
    }
}
