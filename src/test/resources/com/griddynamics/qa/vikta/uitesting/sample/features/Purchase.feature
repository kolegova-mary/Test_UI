Feature: Make a purchase
  As a user I should be able to purchase an item

  @smoke @loginPurchase
  Scenario: Authorized user, which has address and card, should be add an item and purchase it
    Given user opens Login page
    When user logins as regular user
    Then Home is displayed for the regular user
    When user hits details of the item
    Then Item details the current one
    When user hits add to cart
    Then Successful item message is displayed
    And cart is visible for user
    When user hits cart
    Then Cart the current one
    When user hits deliver to and chooses address
    And user hits to be paid by and chooses card
    And user hits purchase
    Then purchase info is displayed