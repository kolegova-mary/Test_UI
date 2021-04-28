package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Login;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Registration functionality related steps.
 */
public class RegistrationSteps extends BaseSteps {
    private static String SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX = "User has been registered successfully: ";
    //TODO: Move to TestContext map as soon as it ready.
    private String loginnameUsed;
    Login login = new Login();

    public RegistrationSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }


    @When("user types in some random value for '([^']+)'")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "LOGINNAME":
                this.loginnameUsed = generateRandomLoginName();
                login.setLoginname(loginnameUsed);
                typeInLoginname(loginnameUsed);
                break;
            case "SURNAME":
                typeInSurname(generateRandomUserNameParameter());
                break;
            case "FIRSTNAME":
                typeInFirstname(generateRandomUserNameParameter());
                break;
            case "PATRONIM":
                typeInPatronim(generateRandomUserNameParameter());
                break;
            case "EMAIL":
                typeInEmail(generateRandomEmail());
                break;
            case "PASSWORD":
                login.setPassword(generateRandomPassword());
                typeInPassword(login.getPassword());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Registration page field name: " + fieldName);
        }
    }

    @When("user hits the Register User button")
    public void toSaveUser() {
        getScenarioContext().setContext("Login", login);
        page().btnRegisterUser.click();
    }

    @Then("Successful registration message is displayed")
    public void verifySuccessfulRegistrationMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        // Have a look at https://assertj.github.io/doc/
        assertThat(getMessageText().trim())
                .as("Successful registration message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX);
    }

    @Then("Successful registration message contains the login name used")
    public void verifySuccessfulRegistrationMessageContainsNewUsername() {
        // Have a look at https://assertj.github.io/doc/
        assertThat(getMessageText().trim())
                .as("Successful registration message was expected to contain the new username used.")
                .contains(loginnameUsed);
    }

    @When("user hits log in")
    public void toLogin() {
        page().btnGoToLoginIn.click();
    }

    public void typeInLoginname(String value) {
        typeIn(value, page().tbLoginName);
    }

    public void typeInSurname(String value) {
        typeIn(value, page().tbSurname);
    }

    public void typeInFirstname(String value) {
        typeIn(value, page().tbFirstName);
    }

    public void typeInPatronim(String value) {
        typeIn(value, page().tbMiddleName);
    }

    public void typeInPassword(String value) {
        typeIn(value, page().tbPassword);
    }

    public void typeInEmail(String value) {
        typeIn(value, page().tbEmail);
    }

    public String getMessageText() {
        return page().tSuccessMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessMessage;
    }

    //TODO: Think about generics etc instead of this.
    private RegistrationPage page() {
        return getPage(RegistrationPage.class);
    }
}