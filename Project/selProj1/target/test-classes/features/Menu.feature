@menu
Feature: Menu Validation

  Scenario: Check Activities menu
    Given user opens CRM site
    When user logs in
    Then activities menu should be visible