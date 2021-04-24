Feature: Log into the application
  As a user I should be able to login into the application

  @smoke @login
  Scenario: Regular user is able to login
    Given user opens Login page
    When user logins as regular user
    Then Home is displayed for the regular user

  @smoke @login
  Scenario: Admin user is able to login
    Given user opens Login page
    When user logins as ADMIN user
    Then Home is displayed for the ADMIN user

  @smoke @login @invalid
  Scenario Outline: Cannon login using invalid username and/or password
    Given user opens Login page
    When user types '<name>' as loginname and '<password>' as password and hits Submit
    Then login error message 'Login name or Password invalid, please verify' is displayed
    Examples:
      |name|password|
      |qq  |qwe     |
      |qw  |123     |
      |za  |az      |
      |qwer|tyuioiop|