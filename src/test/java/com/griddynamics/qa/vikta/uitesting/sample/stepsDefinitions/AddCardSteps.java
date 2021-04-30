package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Card;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddCardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCardSteps extends BaseSteps {
    private String cardNumberUsed;
    private static String SUCCESSFUL_CARD_MESSAGE_PREFIX = "Created payment card ";
    Card card = new Card();

    public AddCardSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }


    @When("user types in some random value for '([^']+)' to add card")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "CARDNUMBER":
                this.cardNumberUsed = generateRandomCardNumber();
                card.setNumber(cardNumberUsed);
                typeInNumber(cardNumberUsed);
                break;
            case "CARDCODE":
                card.setCode(generateRandomCardCode());
                typeInCode(card.getCode());
                break;
            case "OWNER":
                card.setOwner(generateRandomOwner());
                typeInOwner(card.getOwner());
                break;
            case "EXPIRATIONDATE":
                card.setExpirationDate(generateDateString());
                typeInExpirationDate(card.getExpirationDate());
                break;
            case "TAG":
                card.setNickname(generateRandomCardNickname());
                typeInNickname(card.getNickname());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Add card page field name: " + fieldName);
        }
    }

    @When("user hits add/save card")
    public void toSaveCard() {
        getScenarioContext().setContext("Card", card);
        page().btnSaveCard.click();
    }

    @When("user hits clear card")
    public void toResetCard() {
        page().btnClearCard.click();
    }

    @When("user hits delete card")
    public void toDeleteCard(){
        page().btnDelete.click();
    }

    @Then("card fields are empty")
    public void clearFieldsCards() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(page().txtCardNumber.getText()).as("Number").isEqualTo("");
        softly.assertThat(page().txtCode.getText()).as("Code").isEqualTo("");
        softly.assertThat(page().txtDate.getText()).as("Date").isEqualTo("");
        softly.assertThat(page().txtOwner.getText()).as("Owner").isEqualTo("");
        softly.assertThat(page().txtNickname.getText()).as("Nickname").isEqualTo("");
        softly.assertAll();
    }

    @Then("delete button is visible for card")
    public void showDelete(){
        page().btnDelete.isDisplayed();
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
