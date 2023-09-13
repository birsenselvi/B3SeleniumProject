Feature: islemler

  Scenario: sayilarin toplami
    Given initial value is 5
    When user add the following numbers
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
    Then sum should be 21