Feature: Data tables


  Scenario: variable in step
    Given write the following numbers 1 2 3 4 5

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
    Given write the following map
      | Username | 1 |
      | Password | 2 |

  Scenario: list of map
    Given write the following maps
      | Username | Password | Firstname | Lastname|
      | Usernam1 | Passwor1 | Firstnam1 | Lastnam1|
      | Usernam2 | Passwor2 | Firstnam2 | Lastnam2|
      | Usernam3 | Passwor3 | Firstnam3 | Lastnam3|
      | Usernam4 | Passwor4 | Firstnam4 | Lastnam4|
      | Usernam5 | Passwor5 | Firstnam5 | Lastnam5|





