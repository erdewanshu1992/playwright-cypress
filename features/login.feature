Feature: Login
  Scenario: Login with valid credentials
    Given I am on the login page
    When I login with username "user" and password "pass"
    Then I should see the dashboard
