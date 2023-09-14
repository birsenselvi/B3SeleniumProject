Feature: Hook

  @smoke
  Scenario: scenario 1
    Given hooks scenario 1 step 1
    When  hooks scenario 1 step 2
    Then  hooks scenario 1 step 3

  @reg
  Scenario: scenario 2
    Given hooks scenario 2 step 1
    When  hooks scenario 2 step 2
    Then  hooks scenario 2 step 3
