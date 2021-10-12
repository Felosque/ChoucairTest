Feature: Login into the application

  Scenario: Successful login
    Given Felipe Londono has an activity account
    When he sends their valid credentials
    Then he should have access to manage his account

  Scenario: Wrong email login
    Given Antonio Medendez has an activity account
    When he sends their wrong email
    Then he should see an error on the screen

  Scenario: Wrong password login
    Given Alison Gimenez has an activity account
    When he sends their wrong password
    Then he should see an error on the screen