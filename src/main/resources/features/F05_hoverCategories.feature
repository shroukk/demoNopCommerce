#@smoke
Feature: F05_hoverCategories | users could choose the category
  Scenario:
    When user select random one of the three main categories
    And  user select random one of the three sub categories
    Then user is directed to the category page
