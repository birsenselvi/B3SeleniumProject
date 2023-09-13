Feature: map islemleri

  Scenario: map islem 1
    Given my String is as follows
      | ankara   |
      | istanbul |

    When my data is as follows
      | name1  | name2    | name3    |
      | ankara | istanbul | name3    |
      | name1  | istanbul | name3    |
      | name1  | ankara   | istanbul |
      | name1  | name2    | name3    |
    Then the count of the cties are 5