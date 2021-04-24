An extremely simple GUI test automation solution for Vikta application. Based on Cucumber BDD framework.
Contains the very basics of a test automation framework. 
Educational purposes only. Needs heavy refactoring prior to be used for a real project.

# How-to ...:
## ... run some test using maven
```
mvn clean test -Dcucumber.options="--tags @<tag_name>"
```
e.g. to run all the scenarios tagged as "login":
```
mvn clean test -Dcucumber.options="--tags @login"
```

## ...run some test using IntelijIdea
1. Create a JUnit Run/Debug Configuration
2. Set `Class` to `com.griddynamics.qa.vikta.uitesting.sample.TestRunner`
3. Set `VM options` to `-ea "-Dcucumber.options=--tags @<tag_name>"`
e.g.
```
-ea "-Dcucumber.options=--tags @login"
```
4. Save the configuration and use it to run or debug your tests.

## ...view test run report
1. Use maven to run the tests
2. Go to `./target/cucumber-reports`
3. Open `index.html` in a browser


# Hints:
- Install a Cucumber plugin fo IntelijIdea.
- Configure TestRunner configuration in IntelijIdea for local runs and debugging.


# Links:
- https://cucumber.io/docs/guides/overview/
- https://assertj.github.io/doc/
- PageObject related:
    * https://selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/
    * https://martinfowler.com/bliki/PageObject.html
    * https://www.baeldung.com/selenium-webdriver-page-object
    * https://www.pluralsight.com/guides/getting-started-with-page-object-pattern-for-your-selenium-tests



