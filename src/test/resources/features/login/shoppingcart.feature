Feature: Shopping in to the application

  Scenario: Add items to shopping cart
    Given Angelica is logged into the application
    And he wants to add products to his shopping cart
    When he adds 3 products of the same brand
    And he's going to check his shopping cart
    Then he should find the three selected products