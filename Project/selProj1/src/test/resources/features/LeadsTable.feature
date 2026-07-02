@leadstable
Feature: Leads Table Traversal

  Scenario: Print name and user columns
    Given user logs in to CRM
    When user navigates to Leads page
    Then user prints first 10 names and users from table