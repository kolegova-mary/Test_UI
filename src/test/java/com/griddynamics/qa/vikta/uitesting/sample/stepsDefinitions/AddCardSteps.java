package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddAddressPage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddCardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCardSteps extends BaseSteps {
    private String cardNumberUsed;
    private static String SUCCESSFUL_CARD_MESSAGE_PREFIX = "Created payment card ";

    public AddCardSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }


    @When("user types in some random value for '([^']+)' to add card")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "CARDNUMBER":
                this.cardNumberUsed = generateRandomCardNumber();
                typeInNumber(cardNumberUsed);
                break;
            case "CARDCODE":
                typeInCode(generateRandomCardCode());
                break;
            case "OWNER":
                typeInOwner(generateRandomOwner());
                break;
            case "EXPIRATIONDATE":
                typeInExpirationDate(generateDateString());
                break;
            case "NICKNAME":
                typeInNickname(generateRandomCardNickname());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Add card page field name: " + fieldName);
        }
    }

    @When("user hits add/save card")
    public void toSaveCard() {
        page().btnSaveCard.click();
    }

    @When("user hits clear card")
    public void toResetCard() {
        page().btnClearCard.click();
    }

    @Then("Successful card message is displayed")
    public void verifySuccessfulCardMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful add card message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_CARD_MESSAGE_PREFIX);
    }

    @Then("Successful card message contains the number used")
    public void verifySuccessfulCardMessageContainsNewNumber() {
        assertThat(getMessageText().trim())
                .as("Successful card message was expected to contain the new number used.")
                .contains(cardNumberUsed);
    }

    public void typeInNumber(String value) {
        typeIn(value, page().txtCardNumber);
    }

    public void typeInCode(String value) {
        typeIn(value, page().txtCode);
    }

    public void typeInOwner(String value) {
        typeIn(value, page().txtOwner);
    }

    public void typeInExpirationDate(String value) {
        typeIn(value, page().txtDate);
    }

    public void typeInNickname(String value) {
        typeIn(value, page().txtNickname);
    }

    public String getMessageText() {
        return page().tSuccessOrErrorMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessOrErrorMessage;
    }

    private AddCardPage page() {
        return getPage(AddCardPage.class);
    }
}
