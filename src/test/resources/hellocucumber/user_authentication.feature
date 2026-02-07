Feature: User Authentication
  Allows a user to log in and log out of the application securely.

  Background:
    Given the application is running

  Scenario: Successful login with valid credentials
    When the user enters a valid username and password
    Then the user should be connected to the application

  Scenario: Failed login with invalid credentials
    When the user enters an invalid username or password
    Then an error message should be displayed

  Scenario: User attempts multiple failed logins
    When the user enters an invalid username and password three times
    Then the account should be temporarily blocked
    And an appropriate error message should be displayed

  Scenario: User can reset password
    Given the user has forgotten their password
    When the user requests a password reset
    Then a reset link should be sent to the user's registered email

  Scenario: Successful logout
    Given the user is connected to the application
    When the user clicks the logout button
    Then the user should be logged out of the application
    And the login screen should be displayed

  Scenario: Security measures
    Given the password is stored securely
    And the application is accessed via HTTPS
    When the user attempts to log in
    Then the connection should be secure