package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;


import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;

/**
 * Home page related step Definitions
 */
public class HomePageSteps extends BaseSteps {

    //TODO: Add more steps.

    //TODO: Think about generics etc instead of this.
    private HomePage page() {
        return getPage(HomePage.class);
    }

}