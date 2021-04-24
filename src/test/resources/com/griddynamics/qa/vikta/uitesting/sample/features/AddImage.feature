Feature: Add image
  As admin
  I should be able to add a new image

  @addImage
  Scenario: Admin should be able to add and edit image
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user
    When admin hits add image
    Then Add image page the current one
    When admin types in some random value for 'imageurl' to add image
    And admin types in some random value for 'title' to add image
    And admin types in some random value for 'description' to add image
    And admin types in some random value for 'author' to add image
    And admin types in some random value for 'price' to add image
    And admin types in some random value for 'tags' to add image
    And admin hits Save image
    Then Successful add image message is displayed
    And Successful image message contains the title used
    When admin types in some random value for 'title' to add image
    And admin hits Save image
    Then Successful edit image message is displayed
    And Successful edit image message contains the title used


  @clearFields
  Scenario: Image fields should be empty after clicking Reset
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user
    When admin hits add image
    Then Add image page the current one
    When admin types in some random value for 'imageurl' to add image
    And admin types in some random value for 'title' to add image
    And admin types in some random value for 'description' to add image
    And admin types in some random value for 'author' to add image
    And admin types in some random value for 'price' to add image
    And admin types in some random value for 'tags' to add image
    And admin hits Reset image
    Then image fields are empty
