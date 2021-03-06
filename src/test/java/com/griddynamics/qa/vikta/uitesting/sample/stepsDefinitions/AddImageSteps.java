package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddImagePage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddUserPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class AddImageSteps extends BaseSteps {
    private String titleImageUsed;
    private static String SUCCESSFUL_IMAGE_MESSAGE_PREFIX = "Created ";
    private static String SUCCESSFUL_IMAGE_EDIT_MESSAGE_PREFIX = "Updated ";

    public AddImageSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("admin types in some random value for '([^']+)' to add image")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()) {
            case "IMAGEURL":
                typeInImageUrl("http://" + generateRandomString());
                break;
            case "TITLE":
                this.titleImageUsed = generateRandomString();
                typeInImageTitle(titleImageUsed);
                break;
            case "DESCRIPTION":
                typeInImageDescription(generateRandomEmail());
                break;
            case "AUTHOR":
                typeInAuthor(generateRandomString());
                break;
            case "PRICE":
                typeInPrice(generateRandomPrice());
                break;
            case "TAGS":
                typeInTags(generateRandomTags());
                break;
            default:
                throw new IllegalArgumentException("Unsupported Add image page field name: " + fieldName);
        }
    }

    @When("admin hits Save image")
    public void toSaveImage() {
        page().btnSaveImage.click();
    }

    @Then("Successful add image message is displayed")
    public void verifySuccessfulImageMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful image message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_IMAGE_MESSAGE_PREFIX);
    }


    @Then("Successful image message contains the title used")
    public void verifySuccessfulImageMessageContainsNewTitle() {
        assertThat(getMessageText().trim())
                .as("Successful image message was expected to contain the new title used.")
                .contains(titleImageUsed);
    }

    @Then("Successful edit image message is displayed")
    public void verifySuccessfulEditImageMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(getMessageWebElement()));
        assertThat(getMessageText().trim())
                .as("Successful edit image message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_IMAGE_EDIT_MESSAGE_PREFIX);
    }


    @Then("Successful edit image message contains the title used")
    public void verifySuccessfulEditImageMessageContainsNewTitle() {
        assertThat(getMessageText().trim())
                .as("Successful edit image message was expected to contain the new title used.")
                .contains(titleImageUsed);
    }

    @When("admin hits Reset image")
    public void toResetImage() {
        page().btnResetImage.click();
    }

    @Then("image fields are empty")
    public void clearFieldsImage() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(page().txtImageUrl.getText()).as("ImageUrl").isEqualTo("");
        softly.assertThat(page().txtAuthor.getText()).as("Author").isEqualTo("");
        softly.assertThat(page().txtDescription.getText()).as("Description").isEqualTo("");
        softly.assertThat(page().txtTags.getText()).as("Tags").isEqualTo("");
        softly.assertThat(page().txtPrice.getText()).as("Price").isEqualTo("");
        softly.assertThat(page().txtTitle.getText()).as("Title").isEqualTo("");
        softly.assertAll();
    }

    public void typeInImageUrl(String value) {
        typeIn(value, page().txtImageUrl);
    }

    public void typeInImageTitle(String value) {
        typeIn(value, page().txtTitle);
    }

    public void typeInImageDescription(String value) {
        typeIn(value, page().txtDescription);
    }

    public void typeInAuthor(String value) {
        typeIn(value, page().txtAuthor);
    }

    public void typeInPrice(String value) {
        typeIn(value, page().txtPrice);
    }

    public void typeInTags(String value) {
        typeIn(value, page().txtTags);
    }

    public String getMessageText() {
        return page().tSuccessImageMessage.getText();
    }

    public WebElement getMessageWebElement() {
        return page().tSuccessImageMessage;
    }

    public AddImagePage page() {
        return getPage(AddImagePage.class);
    }
}
