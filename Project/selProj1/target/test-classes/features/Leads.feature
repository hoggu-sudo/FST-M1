@leads
Feature: Read lead additional info

  Scenario: Read phone number from popup
    Given user logs in to CRM
    When user navigates to Leads page
    And user clicks additional information icon
    Then user should see phone number in popup