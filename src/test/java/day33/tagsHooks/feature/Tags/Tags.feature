Feature: Tags

  @smoke @temp
  Scenario: Scenario 1
    Given tags scenario 1 step 1
    When tags scenario 1 step 2
    Then tags scenario 1 step 3

  @smoke
  Scenario: Scenario 1
    Given tags scenario 2 step 1
    When tags scenario 2 step 2
    Then tags scenario 2 step 3

  @regression
  Scenario: Scenario 1
    Given tags scenario 3 step 1
    When tags scenario 3 step 2
    Then tags scenario 3 step 3
