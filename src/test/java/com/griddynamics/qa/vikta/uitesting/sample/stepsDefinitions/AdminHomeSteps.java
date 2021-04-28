package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AdminHomePage;
import cucumber.api.java.en.When;

public class AdminHomeSteps extends BaseSteps {
    public AdminHomeSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @When("admin hits add category")
    public void toAddCategory() {
        page().btoAddCategory.click();
    }

    @When("admin hits create user")
    public void toCreateUser() {
        page().btoAddUser.click();
    }

    @When("admin hits add image")
    public void toAddImage(){
        page().btoAddImage.click();
    }

    private AdminHomePage page() {
        return getPage(AdminHomePage.class);
    }
}
