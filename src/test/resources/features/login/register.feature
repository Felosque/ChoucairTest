Feature: Register in to application

  Scenario: Successful register
    Given Felipe Londono is on the registration page
    And he sends a valid email for register
    When he sends valid registration data
    Then he should see the account management screen

  Scenario: Wrong email register
    Given Paola Mendez is on the registration page
    And she sends a wrong email for register
    Then she should see an error on the screen