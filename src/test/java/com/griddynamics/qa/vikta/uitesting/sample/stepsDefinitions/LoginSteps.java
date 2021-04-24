package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Login functionality related steps.
 */
public class LoginSteps extends BaseSteps {
    @When("user types '([^']+)' as loginname and '([^']+)' as password and hits Submit")
    public void goLogin(String username, String password) {
        login(username, password);
    }

    @When("user logins as regular user")
    public void loginAsRegularUser() {
        login(getData().userName(), getData().userPassword());
    }

    @When("user logins as ADMIN user")
    public void loginAsAdmin() {
        login(getData().adminName(), getData().adminPassword());
    }

    @Then("login error message '([^']+)' is displayed")
    public void verifyErrorMessage(String text) {
        getWait().until(ExpectedConditions.visibilityOf(getErrorWebElement()));
        // Have a look at https://assertj.github.io/doc/
        assertThat(getErrorMessage().trim())
                .as("Error message was nor shown or had unexpected content.")
                .contains(text);
    }

    public HomePage login(String username, String password) {
        tryLogin(username, password);
        return new HomePage();
    }

    public void tryLogin(String username, String password) {
        page().txtLoginname.clear();
        page().txtLoginname.sendKeys(username);

        page().txtPassword.clear();
        page().txtPassword.sendKeys(password);

        page().btnSubmitLogin.click();
    }

    public HomePage gotoHome() {
        page().btnGoToHome.click();

        return new HomePage();
    }

    public String getErrorMessage() {
        return page().lblError.getText();
    }

    public WebElement getErrorWebElement() {
        return page().lblError;
    }

    //TODO: Think about generics etc instead of this.
    private LoginPage page() {
        return getPage(LoginPage.class);
    }
}