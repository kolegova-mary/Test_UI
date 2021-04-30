package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Item;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Login;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.UserHomePage;
import cucumber.api.java.ca.I;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserHomeSteps extends BaseSteps {
    Item item = new Item();

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

    @When("user hits details of the item")
    public void toDetails() {
        int cnt = page().bToDetails.size();
        int cur = (int) (Math.random() * cnt);
        String href = page().bToDetails.get(cur).getAttribute("href");
        int startPoint = href.indexOf('=');
        item.setNumber(href.substring(startPoint + 1));
        getScenarioContext().setContext("Item", item.getNumber());
        page().bToDetails.get(cur).click();
    }

    @When("user hits addresses")
    public void toAddresses() {
        page().btnAddresses.click();
    }

    @When("user hits cards")
    public void toCards() {
        page().btnCards.click();
    }

    @When("user hits logout")
    public void toLogOut(){
        page().btnLogOut.click();
    }

    @Then("user is on his Home page")
    public void verifyCurrentPageIsForUser() {
        page().txtUserName.getText().equals(((Login) getScenarioContext().getContext("Login")).getLoginname());
    }

    private UserHomePage page() {
        return getPage(UserHomePage.class);
    }

}
