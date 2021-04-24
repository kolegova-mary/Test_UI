Feature: Create user
  As admin
  I should be able to create and edit user

  @createUser @editUser
  Scenario: Admin is able to create and edit user
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user
    When admin hits create user
    Then Create user page the current one
    When admin types in some random value for 'loginname' to add user
    And admin types in some random value for 'password' to add user
    And admin types in some random value for 'email' to add user
    And admin types in some random value for 'surname' to add user
    And admin types in some random value for 'name' to add user
    And admin types in some random value for 'patronim' to add user
    And admin hits Save the changes
    Then Successful create user message is displayed
    And Successful create user message contains the login name used
    When admin types in some random value for 'loginname' to add user
    And admin hits Save the changes
    Then Successful edit user message is displayed
    And Successful edit user message contains the login name used

  @clearFields
  Scenario: Admin is able to clear fields for user
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user
    When admin hits create user
    Then Create user page the current one
    When admin types in some random value for 'loginname' to add user
    And admin types in some random value for 'password' to add user
    And admin types in some random value for 'email' to add user
    And admin types in some random value for 'surname' to add user
    And admin types in some random value for 'name' to add user
    And admin types in some random value for 'patronim' to add user
    And admin hits clear it out for user
    Then fields are empty for user

