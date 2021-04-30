package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;


import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Item;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import cucumber.api.java.en.When;

/**
 * Home page related step Definitions
 */
public class HomePageSteps extends BaseSteps {
    Item item = new Item();

    public HomePageSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("non-authorized user hits details of the item")
    public void toDetails() {
        int cnt = page().bToDetails.size();
        int cur = (int) (Math.random() * cnt);
        String href = page().bToDetails.get(cur).getAttribute("href");
        int startPoint = href.indexOf('=');
        item.setNumber(href.substring(startPoint + 1));
        getScenarioContext().setContext("Item", item.getNumber());
        page().bToDetails.get(cur).click();
    }

    //TODO: Add more steps.

    //TODO: Think about generics etc instead of this.
    private HomePage page() {
        return getPage(HomePage.class);
    }

}