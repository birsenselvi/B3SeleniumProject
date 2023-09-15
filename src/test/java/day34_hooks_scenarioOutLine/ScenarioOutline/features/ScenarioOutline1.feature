Feature: Scenario Outline

  Scenario: scenario 1
    Given so scenario 1 step 1
    When  so scenario 1 step 2
    Then  so scenario 1 step 3

  Scenario: scenario 2
    Given so scenario 2 step 1
    When  so login with the following data
      | username | admin |
      | password | pass1 |
    Then so scenario 2 step 3

    @so
  Scenario Outline: scenario outline
    Given so my name is "<name>"
    When so mey age is <age>
    Then so my country is "<city>"
    Examples:
      | name  | age | city   |
      | selvi | 33  | ankara |
      | Elif  | 10  | ankara |
      | yusuf | 6   | ankara |
