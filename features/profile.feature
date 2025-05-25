Feature: Profile Update
  Scenario: Update profile successfully
    Given I am on the profile page
    When I update my name and email
    Then I should see a success message
