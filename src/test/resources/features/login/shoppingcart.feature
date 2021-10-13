Feature: Shopping in to the application

  Scenario: Add items to shopping cart
    Given Rodolfo is logged into the application
    And he wants to add products to his shopping cart
    When he adds 13 products of the same brand
    And he's going to check his shopping cart
    Then he should find the three selected products

  Scenario: Finish checkout
    Given Santiago is logged into the application
    And he wants to add products to his shopping cart
    When he adds 5 products of the same brand
    And he's going to check his shopping cart
    Then he should find the three selected products