package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.Hooks;
import com.griddynamics.qa.vikta.uitesting.sample.ScenarioContext;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.config.TestDataAndProperties;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Base class to contain common auxiliary methods for step definitions.
 */
abstract class BaseSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    protected WebDriver getDriver() {
        return Hooks.driver;
    }

    protected WebDriverWait getWait() {
        if (Objects.isNull(this.wait)) {
            this.wait = new WebDriverWait(driver, getData().waitTimeout());
        }

        return wait;
    }

    protected TestDataAndProperties getData() {
        return DataProvider.get();
    }

    protected <P> P getPage(Class<P> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    protected void verifyCurrentPageIsHomePageForTheUser(String username) {
        BasePage currentPage = getPage(BasePage.class);
        getWait().until(ExpectedConditions.visibilityOf(currentPage.getLoggedInName()));

        assertCurrentPageUrl(getData().baseUrl(), "Home page was expected to be the current one.");

        assertThat(currentPage.getCurrentUserName())
                .as("Unexpected current user's name displayed. Expected: %s", username)
                .contains(username);
        //TODO: Assert displayed role as well.
    }

    protected void assertCurrentPageUrl(String expectedUrl, String messageOnFail) {
        assertThat(getDriver().getCurrentUrl())
                .as(messageOnFail)
                .contains(expectedUrl);
    }

    //TODO: Make static and move to some Utils.
    //TODO: Use something like JavaFaker.
    protected String generateRandomString(int max, int min) {

        String candidate = UUID.randomUUID().toString().replaceAll("\\d", "A");
        if (candidate.length() < min) {
            throw new IllegalArgumentException("Size must be bigger");
        } else {
            if (candidate.length() > max) {
                return candidate.substring(0, max);
            } else {
                return candidate;
            }
        }
    }

    public void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

    protected String generateRandomLoginName() {
        return generateRandomString(729, 1);
    }

    protected String generateRandomPassword() {
        return generateRandomString(288, 1);
    }

    protected String generateRandomEmail() {
        String[] domens = new String[]{".ru", ".com"};
        return generateRandomString(250, 1) + "@" +
                generateRandomString(120, 1) + domens[(int) (Math.random() * domens.length)];

    }

    protected String generateRandomUserNameParameter() {
        return generateRandomString(288, 1);
    }

    protected String generateRandomStreet() {
        return generateRandomString(3010, 1);
    }

    protected String generateRandomStreetAdditionalOrCity() {
        return generateRandomString(1024, 1);
    }

    protected String generateRandomRegion() {
        return generateRandomString(4096, 1);
    }

    protected String generateRandomPostalCode() {
        return generateRandomString(20, 1);
    }

    protected String generateRandomCardNickname() {
        return generateRandomString(4096, 1);
    }

    protected String generateRandomCardNumber() {
        Integer cnt = 2 + (int) (Math.random() * 3);
        String candidate = "";
        for (int i = 0; i < 3; i++) {
            candidate += generateRandomCardCode();
        }
        for (int i = 0; i < cnt; i++) {
            Integer cur = (int) (Math.random() * 10);
            String last = cur.toString();
            candidate += last;
        }
        return candidate;
    }

    protected String generateRandomCardCode() {
        Integer cur = 1000 + (int) (Math.random() * 9000);
        return cur.toString();
    }

    protected String generateRandomOwner() {
        return generateRandomString(4096, 1);
    }

    protected String generateRandomAddressNickname() {
        return generateRandomString(2048, 1);
    }

    protected String generateRandomPrice() {
        Double cur = Math.random() * 10000;
        return cur.toString();
    }

    protected String generateDateString() {
        LocalDateTime rangeEnd = LocalDateTime.now().minusMinutes(1);
        LocalDateTime rangeStart = rangeEnd.minusYears(71);

        long diffInMillis = rangeEnd.toEpochSecond(ZoneOffset.UTC) - rangeStart.toEpochSecond(ZoneOffset.UTC);
        long resultInMillis = (long) (rangeStart.toEpochSecond(ZoneOffset.UTC) + Math.random() * diffInMillis);

        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(resultInMillis, 0, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDateTime);
    }

    protected String generateRandomTags() {
        String cur = "[";
        Integer cnt = (int) (Math.random() * 12);
        for (int i = 0; i < cnt; i++) {
            cur += generateRandomString(7, 2) + ", ";
        }
        return cur += generateRandomString(7, 2) + "]";
    }

    protected String generateRandomString() {
        return generateRandomString(16, 4);
    }

    public ScenarioContext scenarioContext;

    public BaseSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }


    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
