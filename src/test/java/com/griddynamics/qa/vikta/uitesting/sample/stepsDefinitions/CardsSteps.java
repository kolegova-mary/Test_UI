package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Address;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Card;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.CardsPage;
import cucumber.api.java.en.Then;
import gherkin.lexer.Ca;

public class CardsSteps extends BaseSteps {
    public CardsSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @Then("number is the same")
    public void verifyNumberIsTheSame() {
        page().tdNumber.getText().equals(((Card) getScenarioContext().getContext("Card")).getNumber());
    }

    @Then("code is the same")
    public void verifyCodeIsTheSame() {
        page().tdCode.getText().equals(((Card) getScenarioContext().getContext("Card")).getCode());
    }

    @Then("owner is the same")
    public void verifyOwnerIsTheSame() {
        page().tdOwner.getText().equals(((Card) getScenarioContext().getContext("Card")).getOwner());
    }

    @Then("date is the same")
    public void verifyDateIsTheSame() {
        page().tdExpiration.getText().equals(((Card) getScenarioContext().getContext("Card")).getExpirationDate());
    }

    @Then("tag is the same")
    public void verifyTagIsTheSame() {
        page().tdTags.getText().equals(((Card) getScenarioContext().getContext("Card")).getNickname());
    }

    private CardsPage page() {
        return getPage(CardsPage.class);
    }
}
