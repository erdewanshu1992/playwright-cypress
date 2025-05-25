Feature: Dashboard
  Scenario: Navigate to profile
    Given I am logged in
    When I click the profile link
    Then I should see my profile page
