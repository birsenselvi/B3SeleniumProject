Feature: Data tables


  Scenario: variable in step
    Given write the following numbers 1, 2, 3, 4, 5

  # DataTable: List -> Tek satirdir, asagi dogru uzar
  Scenario: list as datatable
    Given write the following numbers
      | 1 |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
      | 6 |

  Scenario: list as datatable String
    Given write the following string
      | a |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
      | z |



  Scenario: list of Lists
    Given write the following listOfLists
      | a  | b  | c  | d  |
      | 2  | 12 | 22 | 32 |
      | 3  | 13 | 23 | 33 |
      | 4  | 14 | 24 | 34 |
      | 5  | 15 | 25 | 35 |
      | z1 | z2 | z3 | z4 |

  Scenario: list of Lists as integer
    Given write the following listOfLists as int
      | 2  | 12 | 22 | 32 |
      | 3  | 13 | 23 | 33 |
      | 4  | 14 | 24 | 34 |
      | 5  | 15 | 25 | 35 |
