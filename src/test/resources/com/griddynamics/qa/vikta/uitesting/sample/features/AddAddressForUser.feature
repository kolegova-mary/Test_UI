Feature: Add address
  As user
  I should be able to add a new address

  @addAddress
  Scenario: User registers, login and then should be able to add Address
    Given user opens Registration page
    When user types in some random value for 'loginname'
    And user types in some random value for 'surname'
    And user types in some random value for 'firstname'
    And user types in some random value for 'patronim'
    And user types in some random value for 'email'
    And user types in some random value for 'password'
    And user hits the Register User button
    Then Registration page the current one
    Then Successful registration message is displayed
    And Successful registration message contains the login name used

    When user hits log in
    Then Login the current one
    When user types loginname and password and hits Submit
    Then user is on his Home page

    When user hits add address
    Then Add address for the user the current one
    When user types in some random value for 'streetname' to add address
    And user types in some random value for 'additionalinfo' to add address
    And user types in some random value for 'city' to add address
    And user types in some random value for 'region' to add address
    And user types in some random value for 'postalcode' to add address
    And user types in some random value for 'addressnickname' to add address
    And user hits add/save address
    Then Successful add address message is displayed
    And Successful address message contains the street used

    When user hits addresses
    Then Addresses the current one
    And street is the same
    And additional info is the same
    And city is the same
    And region is the same
    And postalcode is the same
    And nickname is the same

