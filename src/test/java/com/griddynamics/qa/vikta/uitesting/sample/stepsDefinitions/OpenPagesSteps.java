package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import cucumber.api.java.en.Given;

public class OpenPagesSteps extends BaseSteps {
    public OpenPagesSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }


    @Given("user opens Registration page")
    public void openRegistrationPage() {
        getDriver().get(getData().registrationPageUrl());
    }

    @Given("user opens Login page")
    public void openLoginPage() throws Throwable {
        getDriver().get(getData().loginPageUrl());
    }

    @Given("admin opens Add category page")
    public void openAddCategoryPage(){
        getDriver().get(getData().adminAddCategoryPageUrl());
    }
}
