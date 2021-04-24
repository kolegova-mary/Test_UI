package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddUserPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class AddUserSteps extends HomePageSteps {
    private static String SUCCESSFUL_ADD_USER_MESSAGE_PREFIX = "Created user account ";
    private static String SUCCESSFUL_EDIT_USER_MESSAGE_PREFIX = "Updated user account ";

    private String loginnameUsed;

    @When("admin types in some random value for '([^']+)' to add user")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "LOGINNAME":
                this.loginnameUsed = generateRandomString();
                typeInLoginname(loginnameUsed);
                break;
            case "PASSWORD":
                typeInPassword(generateRandomString());
                break;
            case "EMAIL":
                typeInEmail(generateRandomEmail());
                break;
            case "SURNAME":
                typeInSurname(generateRandomString());
                break;
            case "NAME":
                typeInFirstname(generateRandomString());
                break;
            case "PATRONIM":
                typeInPatronim(generateRandomString());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Create user page field name: " + fieldName);
        }
    }

    @When("admin hits Save the changes")
    public void toSaveUser() {
        page().btnSaveUser.click();
    }

    @Then("Successful create user message is displayed")
    public void verifySuccessfulCreateUserMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful create user message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_ADD_USER_MESSAGE_PREFIX);
    }

    @Then("Successful create user message contains the login name used")
    public void verifySuccessfulCreateUserMessageContainsNewUsername() {
        assertThat(getMessageText().trim())
                .as("Successful create user message was expected to contain the new username used.")
                .contains(loginnameUsed);
    }

    @Then("Successful edit user message is displayed")
    public void verifySuccessfulEditUserMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful edit user message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_EDIT_USER_MESSAGE_PREFIX);
    }

    @Then("Successful edit user message contains the login name used")
    public void verifySuccessfulEditUserContainsNewUsername() {
        assertThat(getMessageText().trim())
                .as("Successful edit user message was expected to contain the new username used.")
                .contains(loginnameUsed);
    }

    @When("admin hits clear it out for user")
    public void toResetUser() {
        page().btnClearItOut.click();
    }

    @Then("fields are empty for user")
    public void clearFields() {
        assertTrue(checkIfWebElementEmpty(page().txtEmail) && checkIfWebElementEmpty(page().txtPassword)
                && checkIfWebElementEmpty(page().txtLoginName) && checkIfWebElementEmpty(page().txtMiddleName)
                && checkIfWebElementEmpty(page().txtName) && checkIfWebElementEmpty(page().txtSurname));
    }

    public void typeInLoginname(String value) {
        typeIn(value, page().txtLoginName);
    }

    public void typeInSurname(String value) {
        typeIn(value, page().txtSurname);
    }

    public void typeInFirstname(String value) {
        typeIn(value, page().txtName);
    }

    public void typeInPatronim(String value) {
        typeIn(value, page().txtMiddleName);
    }

    public void typeInPassword(String value) {
        typeIn(value, page().txtPassword);
    }

    public void typeInEmail(String value) {
        typeIn(value, page().txtEmail);
    }

    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    public String getMessageText() {
        return page().tSuccessMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessMessage;
    }

    private AddUserPage page() {
        return getPage(AddUserPage.class);
    }
}
