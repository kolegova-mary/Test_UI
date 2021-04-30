package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Address;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddAddressPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AddAddressSteps extends BaseSteps {
    private String streetUsed;
    private static String SUCCESSFUL_ADDRESS_MESSAGE_PREFIX = "Created user address ";
    Address address = new Address();

    public AddAddressSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("user types in some random value for '([^']+)' to add address")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "STREETNAME":
                this.streetUsed = generateRandomStreet();
                address.setStreet(streetUsed);
                typeInStreet(streetUsed);
                break;
            case "ADDITIONALINFO":
                address.setAdditionalStreetInfo(generateRandomStreetAdditionalOrCity());
                typeInAdditional(address.getAdditionalStreetInfo());
                break;
            case "CITY":
                address.setCity(generateRandomStreetAdditionalOrCity());
                typeInCity(address.getCity());
                break;
            case "REGION":
                address.setRegion(generateRandomRegion());
                typeInRegion(address.getRegion());
                break;
            case "POSTALCODE":
                address.setPostalCode(generateRandomPostalCode());
                typeInPostal(address.getPostalCode());
                break;
            case "ADDRESSNICKNAME":
                address.setAddressNickname(generateRandomAddressNickname());
                typeInNickname(address.getAddressNickname());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Add address page field name: " + fieldName);
        }
    }

    @When("user hits add/save address")
    public void toSaveAddress() {
        getScenarioContext().setContext("Address", address);
        page().btnSave.click();
    }

    @When("user hits clear address")
    public void toResetAddress() {
        page().btnReset.click();
    }

    @When("user hits delete address")
    public void toDeleteAddress(){
        page().btnDelete.click();
    }

    @Then("address fields are empty")
    public void clearFieldsAddress() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(page().txtStreet.getText()).as("Street").isEqualTo("");
        softly.assertThat(page().txtAdditionalStreetInfo.getText()).as("AdditionalInfo").isEqualTo("");
        softly.assertThat(page().txtCity.getText()).as("City").isEqualTo("");
        softly.assertThat(page().txtRegion.getText()).as("Region").isEqualTo("");
        softly.assertThat(page().txtPostalCode.getText()).as("PostalCode").isEqualTo("");
        softly.assertThat(page().txtAddressNickname.getText()).as("AddressNickname").isEqualTo("");
        softly.assertAll();
    }

    @Then("delete button is visible for address")
    public void showDelete(){
        page().btnDelete.isDisplayed();
    }

    @Then("Successful add address message is displayed")
    public void verifySuccessfulAddressMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful address message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_ADDRESS_MESSAGE_PREFIX);
    }

    @Then("Successful address message contains the street used")
    public void verifySuccessfulAddressMessageContainsNewStreetNumber() {
        assertThat(getMessageText().trim())
                .as("Successful address message was expected to contain the new street used.")
                .contains(streetUsed);
    }

    public void typeInStreet(String value) {
        typeIn(value, page().txtStreet);
    }

    public void typeInAdditional(String value) {
        typeIn(value, page().txtAdditionalStreetInfo);
    }

    public void typeInCity(String value) {
        typeIn(value, page().txtCity);
    }

    public void typeInRegion(String value) {
        typeIn(value, page().txtRegion);
    }

    public void typeInPostal(String value) {
        typeIn(value, page().txtPostalCode);
    }

    public void typeInNickname(String value) {
        typeIn(value, page().txtAddressNickname);
    }

    public String getMessageText() {
        return page().tSuccessOrErrorMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessOrErrorMessage;
    }

    private AddAddressPage page() {
        return getPage(AddAddressPage.class);
    }

}
