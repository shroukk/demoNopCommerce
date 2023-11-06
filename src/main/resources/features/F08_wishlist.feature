@smoke
Feature: F08_WishList | users could add product to the wishlist
  Scenario: user add product to the wishlist
    When user add the third product to the wishlist
    Then success message will be appeared
  Scenario: user opens the wishlist page
    When user add the third product to the wishlist
    And  user click on Wishlist Tab
    Then user will be directed to the wishlist page
