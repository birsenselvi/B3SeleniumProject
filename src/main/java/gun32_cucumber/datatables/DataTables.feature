Feature: data tables

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
      | 2 | 12 | 22 | 32 |
      | 3 | 13 | 23 | 33 |
      | 4 | 14 | 24 | 34 |
      | 5 | 15 | 25 | 35 |


  Scenario: map
    Given write the following as map
      | username  | uname1 |
      | password  | pass   |
      | firstname | ali    |
      | lastname  | veli   |


  Scenario: map with numbers
    Given write the following numbers as map
      | 1 | 1.2 |
      | 2 | 2.3 |
      | 3 | 3.6 |
      | 4 | 7.1 |


  Scenario: list of maps
    Given write the following maps
      | username | password | firstname  | lastname  |
      | uname1   | pass1    | firstname1 | lastname1 |
      | uname2   | pass2    | firstname2 | lastname2 |
      | uname3   | pass3    | firstname3 | lastname3 |
      | uname4   | pass4    | firstname4 | lastname4 |
      | uname5   | pass5    | firstname5 | lastname5 |