Feature: OrangeHRM

  Scenario: login
    Given user on homepage
    When user login with the following credentials
      | username | Admin    |
      | password | admin123 |
    Then login should be successful