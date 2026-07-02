@login
Feature: Login to CRM

  Scenario: Successful login
    Given user opens CRM site
    When user enters valid credentials
    And clicks login button
    Then user should see homepage
