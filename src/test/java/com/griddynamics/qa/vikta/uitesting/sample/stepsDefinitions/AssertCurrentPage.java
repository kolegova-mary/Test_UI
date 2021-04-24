package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import cucumber.api.java.en.Then;

public class AssertCurrentPage extends BaseSteps {
    @Then("Home is displayed for the regular user")
    public void verifyCurrentPageIsHomePageForTheRegularUser() {
        verifyCurrentPageIsHomePageForTheUser(getData().userName());
    }

    @Then("Home is displayed for the ADMIN user")
    public void verifyCurrentPageIsHomePageForTheAdmin() {
        verifyCurrentPageIsHomePageForTheUser(getData().adminName());
    }

    @Then("Registration page the current one")
    public void verifyCurrentPageIsRegistration() {
        assertCurrentPageUrl(getData().registrationPageUrl(), "Registration page was expected to be the current one.");
    }

    @Then("Add category page the current one")
    public void verifyCurrentPageIsAddCategoryForTheAdmin() {
        assertCurrentPageUrl(getData().adminAddCategoryPageUrl(), "Add category page was expected to be the current one.");
    }

    @Then("Create user page the current one")
    public void verifyCurrentPageIsCreateUserForTheAdmin() {
        assertCurrentPageUrl(getData().adminCreateUserPageUrl(), "Add user page was expected to be the current one.");
    }

    @Then("Add image page the current one")
    public void verifyCurrentPageIsAddImageForTheAdmin(){
        assertCurrentPageUrl(getData().adminAddImagePageUrl(),"Add image page was expected to be the current one.");
    }
}
