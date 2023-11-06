@smoke
Feature: F01_Register | users could register with new accounts
  Scenario:
    Given user go to register page
    When user select gender type
    And  user enter first name "automation"
    And  last name "tester"
    And user enter date of birth
    And user enter email "test@example.com" field
    And user fills Password field "P@ssw0rd"
    And user fills confirm password field "P@ssw0rd"
    And user clicks on register button
    Then success message is displayed



