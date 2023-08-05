#@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario:
    Given user go to login page
    When  user enter valid email "test@example.com"
    And   user enter valid password "P@ssw0rd"
    And   user press on login button
    Then  user login to the system successfully

  Scenario:
    Given user go to login page
    When user enter invalid email "wrong@example.com"
    And  user enter invalid password "wrong"
    And  user press on login button
    Then user could not login to the system
