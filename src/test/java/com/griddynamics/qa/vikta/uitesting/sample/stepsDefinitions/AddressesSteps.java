package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.elements.Address;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddressesPage;
import cucumber.api.java.en.Then;

public class AddressesSteps extends BaseSteps {
    public AddressesSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @Then("street is the same")
    public void verifyStreetIsTheSame() {
        page().tdStreet.getText().equals(((Address) getScenarioContext().getContext("Address")).getStreet());
    }

    @Then("additional info is the same")
    public void verifyAdditionalIsTheSame() {
        page().tdAdditionalStreet.getText().equals(((Address) getScenarioContext().getContext("Address")).getAdditionalStreetInfo());
    }

    @Then("city is the same")
    public void verifyCityIsTheSame() {
        page().tdCity.getText().equals(((Address) getScenarioContext().getContext("Address")).getCity());
    }

    @Then("region is the same")
    public void verifyRegionIsTheSame() {
        page().tdRegion.getText().equals(((Address) getScenarioContext().getContext("Address")).getRegion());
    }

    @Then("postalcode is the same")
    public void verifyPostalIsTheSame() {
        page().tdPostal.getText().equals(((Address) getScenarioContext().getContext("Address")).getPostalCode());
    }

    @Then("nickname is the same")
    public void verifyNicknameIsTheSame() {
        page().tdNickname.getText().equals(((Address) getScenarioContext().getContext("Address")).getAddressNickname());
    }

    private AddressesPage page() {
        return getPage(AddressesPage.class);
    }
}
