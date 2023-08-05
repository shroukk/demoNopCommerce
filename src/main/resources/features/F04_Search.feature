#@smoke
Feature: F04_Search | users could search for the products
  Scenario Outline:
    When user could search using productname "<productName>"
    And  user press on search button
    Then user is directed to the result products using name "<productName>" page
    Examples:
      | productName |
      | book        |
      | laptop      |
      | nike        |
  Scenario Outline:
    When user could search using serial number "<sku>"
    And  user press on search button
    Then user is directed to the result products using serial number "<sku>" page
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
