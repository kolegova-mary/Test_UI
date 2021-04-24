Feature: Add category
  As admin
  I should be able to add a new category

  @addCategory
  Scenario: Admin should be able to add and edit category
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user
    When admin hits add category
    Then Add category page the current one
    When admin types in some random value for 'title' to add category
    And admin types in some random value for 'description' to add category
    Then path inserts
    When admin hits Save category
    Then Successful add category message is displayed
    And Successful category message contains the title used
    When admin types in some random value for 'title' to add category
    And admin hits Save category
    Then Successful edit category message is displayed
    And Successful edit category message contains the title used

  @clearFields
  Scenario: Admin should be able clear fields for category
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user
    When admin hits add category
    Then Add category page the current one
    When admin types in some random value for 'title' to add category
    And admin types in some random value for 'description' to add category
    Then path inserts
    When admin hits Reset category
    Then fields are empty for category