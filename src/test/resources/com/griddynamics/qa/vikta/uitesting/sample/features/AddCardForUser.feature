Feature: Add card
  As user
  I should be able to add a new card

  @addCard  @smoke
  Scenario: User registers, login and then should be able to add Card
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

    When user hits log in
    Then Login the current one
    When user types loginname and password and hits Submit
    Then user is on his Home page

    When user hits add card
    Then Add card for the user the current one
    When user types in some random value for 'cardnumber' to add card
    And user types in some random value for 'cardcode' to add card
    And user types in some random value for 'owner' to add card
    And user types in some random value for 'expirationdate' to add card
    And user types in some random value for 'tag' to add card
    And user hits add/save card
    Then Successful card message is displayed
    And Successful card message contains the number used

    When user hits cards
    Then Cards the current one
    And number is the same
    And code is the same
    And owner is the same
    And date is the same
    And tag is the same

    @smoke @clearFields
      Scenario: User should be able to clear fields for card
      Given user opens Login page
      When user logins as regular user
      Then Home is displayed for the regular user
      When user hits add card
      Then Add card for the user the current one
      When user types in some random value for 'cardnumber' to add card
      And user types in some random value for 'cardcode' to add card
      And user types in some random value for 'owner' to add card
      And user types in some random value for 'expirationdate' to add card
      And user types in some random value for 'tag' to add card
      And user hits clear card
      Then card fields are empty

      @smoke @deleteCard
        Scenario: User should be able to delete card, which has just been added
  Scenario: User should be able to clear fields for card
    Given user opens Login page
    When user logins as regular user
    Then Home is displayed for the regular user
    When user hits add card
    Then Add card for the user the current one
    When user types in some random value for 'cardnumber' to add card
    And user types in some random value for 'cardcode' to add card
    And user types in some random value for 'owner' to add card
    And user types in some random value for 'expirationdate' to add card
    And user types in some random value for 'tag' to add card
    And user hits add/save card
    And user hits delete card
    Then card fields are empty

