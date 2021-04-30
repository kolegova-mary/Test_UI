Feature: User registration
  As a guest user
  I should be able to register new user account(sign-up) and use it to login into the application

  @signup @smoke
  Scenario: Guest user is able to register new regular user account and use it to login
    Given user opens Registration page
    When user types in some random value for 'loginname' to register
    And user types in some random value for 'surname' to register
    And user types in some random value for 'firstname' to register
    And user types in some random value for 'patronim' to register
    And user types in some random value for 'email' to register
    And user types in some random value for 'password' to register
    And user hits the Register User button
    Then Registration page the current one
    Then Successful registration message is displayed
    And Successful registration message contains the login name used
# TODO: Develop the rest of the scenario. E.g. login as new user etc.
#

#  @smoke TODO: Uncomment when the scenario is ready.
  @signup
  Scenario: Guest user is NOT able to register regular user account using some existing user account's name
# TODO: Develop the rest of the scenario.