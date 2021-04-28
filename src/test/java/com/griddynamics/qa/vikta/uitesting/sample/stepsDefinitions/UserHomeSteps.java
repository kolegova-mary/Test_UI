package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Login;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.UserHomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserHomeSteps extends BaseSteps {
    public UserHomeSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("user hits add address")
    public void toAddAddress() {
        page().btnToAddAddress.click();
    }

    @When("user hits add card")
    public void toAddCard() {
        page().btnToAddCard.click();
    }

    @When("user hits addresses")
    public void toAddresses() {
        page().btnAddresses.click();
    }

    @When("user hits cards")
    public void toCards() {
        page().btnCards.click();
    }

    @Then("user is on his Home page")
    public void verifyCurrentPageIsForUser() {
        page().txtUserName.getText().equals(((Login) getScenarioContext().getContext("Login")).getLoginname());
    }

    private UserHomePage page() {
        return getPage(UserHomePage.class);
    }

}
