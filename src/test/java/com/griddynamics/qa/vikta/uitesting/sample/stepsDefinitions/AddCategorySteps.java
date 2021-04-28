package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddCategoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class AddCategorySteps extends BaseSteps {
    private String titleUsed;
    private static String SUCCESSFUL_CATEGORY_MESSAGE_PREFIX = "Created category: ";
    private static String SUCCESSFUL_EDIT_CATEGORY_MESSAGE_PREFIX = "Updated category: ";

    public AddCategorySteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }


    @When("admin types in some random value for '([^']+)' to add category")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "TITLE":
                this.titleUsed = generateRandomString();
                typeInTitle(titleUsed);
                break;
            case "DESCRIPTION":
                typeInDescription(generateRandomString());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Add category page field name: " + fieldName);
        }
    }

    @Then("path inserts")
    public void insertPath() {
        typeIn("https://shnyagi.net/uploads/pic/2017/09-03/kotiki_017.jpg", page().txtPath);
    }

    @When("admin hits Save category")
    public void toSaveCategory() {
        page().bToSave.click();
    }

    @Then("Successful add category message is displayed")
    public void verifySuccessfulCategoryMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful category message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_CATEGORY_MESSAGE_PREFIX);
    }

    @Then("Successful category message contains the title used")
    public void verifySuccessfulCategoryMessageContainsNewTitle() {
        assertThat(getMessageText().trim())
                .as("Successful category message was expected to contain the new title used.")
                .contains(titleUsed);
    }

    @Then("Successful edit category message is displayed")
    public void verifySuccessfulEditCategoryMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful edit category message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_EDIT_CATEGORY_MESSAGE_PREFIX);
    }

    @Then("Successful edit category message contains the title used")
    public void verifySuccessfulEditCategoryMessageContainsNewTitle() {
        assertThat(getMessageText().trim())
                .as("Successful edit category message was expected to contain the new title used.")
                .contains(titleUsed);
    }

    @When("admin hits Reset category")
    public void toResetCategory() {
        page().bToReset.click();
    }

    @Then("fields are empty for category")
    public void clearFieldsCategory() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(page().txtDescription.getText()).as("Description").isEqualTo("");
        softly.assertThat(page().txtPath.getText()).as("Path").isEqualTo("");
        softly.assertThat(page().txtTitle.getText()).as("Title").isEqualTo("");
        softly.assertAll();
    }

    public void typeInTitle(String value) {
        typeIn(value, page().txtTitle);
    }

    public void typeInDescription(String value) {
        typeIn(value, page().txtDescription);
    }

    public String getMessageText() {
        return page().tSuccessOrErrorMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessOrErrorMessage;
    }

    private AddCategoryPage page() {
        return getPage(AddCategoryPage.class);
    }

}
