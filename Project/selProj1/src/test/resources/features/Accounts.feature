@accounts
Feature: Traversing Accounts Table

  Scenario: Print first 5 odd-numbered rows
    Given user logs in to CRM
    When user navigates to Accounts page
    Then user prints first 5 odd rows from accounts table