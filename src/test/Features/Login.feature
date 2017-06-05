Feature: LoginFeature
  This feature

  Scenario: Login with correct username and pass
    Given I navigate to the login page
    And I enter the username as admin and password as admin
    And I click on login button
    Then I should see the userform page
