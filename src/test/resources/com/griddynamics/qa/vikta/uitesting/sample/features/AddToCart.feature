Feature: Add to cart
  Guest should be able to choose an item

  @smoke @nonAuthorizedAddToCart
  Scenario: Guest should be able to choose item and go to login
    Given user opens home page
    When non-authorized user hits details of the item
    Then Item details the current one
    When user hits add to cart
    Then Login the current one
