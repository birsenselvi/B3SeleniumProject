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

    # List<String> list = dataTable.asList(String.class);
    # List<String> list = dataTable.asList();
    # DataType String ise String.class'a gerek yok
    # List<Integer> list = dataTable.asList(Integer.class);
  Scenario: list as datatable String
    Given write the following string
      | a |
      | 2 |
      | 3 |
      | 4 |
      | 5 |
      | z |


    # List of Lists
    # List<List<String>> lists = dataTable.asLists(String.class)
    # List<List<String>> lists = dataTable.asLists()
    # DataType String ise String.class'a gerek yok
  Scenario: list of Lists one row
    Given write the following listOfLists
      | a | b | c | d |


    # List<List<Integer>> lists = dataTable.asLists(Integer.class)
  Scenario: list of Lists
    Given write the following listOfLists
      | a  | b  | c  | d  |
      | 2  | 12 | 22 | 32 |
      | 3  | 13 | 23 | 33 |
      | 4  | 14 | 24 | 34 |
      | 5  | 15 | 25 | 35 |
      | z1 | z2 | z3 | z4 |



    # List of Lists
    # List<List<Integer>> lists = dataTable.asLists()
  Scenario: list of Lists as integer
    Given write the following listOfLists as int
      | 2 | 12 | 22 | 32 |
      | 3 | 13 | 23 | 33 |
      | 4 | 14 | 24 | 34 |
      | 5 | 15 | 25 | 35 |




    # Map<String, String> map = dataTable.asMap(String.class, String.class);
    # Map<String, Integer> map = dataTable.asMap(String.class, Integer.class);
    # Map<String, String> map = dataTable.asMap();
    # Tüm DataType'lar String ise String.class yazmaya gerek yok
  Scenario: map
    Given write the following as map
      | username  | uname1 |
      | password  | pass   |
      | firstname | ali    |
      | lastname  | veli   |

  Scenario: list
    Given write the following string
      | uname1 |
      | pass   |
      | ali    |
      | veli   |


    # Map<Integer, Double> map = dataTable.asMap(Integer.class, Double.class);
  Scenario: map with numbers
    Given write the following numbers as map
      | 1 | 1.2 |
      | 2 | 2.3 |
      | 3 | 3.6 |
      | 4 | 7.1 |


    # List<Map<String, String>> listOfMaps = dataTable.asMaps(String.class, String.class)
    # List<Map<String, String>> listOfMaps = dataTable.asMaps()
    # Tüm DataType'lar String ise String.class yazmaya gerek yok
    # List<Map<String, Integer>> listOfMaps = dataTable.asMaps(String.class, Integer.class)
  Scenario: list of maps
    Given write the following maps
      | username | password | firstname  | lastname  |
      | uname1   | pass1    | firstname1 | lastname1 |
      | uname2   | pass2    | firstname2 | lastname2 |
      | uname3   | pass3    | firstname3 | lastname3 |
      | uname4   | pass4    | firstname4 | lastname4 |
      | uname5   | pass5    | firstname5 | lastname5 |


    # List<Map<String, Object>> listOfMaps = dataTable.asMaps(String.class, Object.class)
  Scenario: list of maps 2
    Given write the following maps with for
      | name | age | city      |
      | Ali1 | 41  | Istanbul1 |
      | Ali2 | 42  | Istanbul2 |
      | Ali3 | 43  | Istanbul3 |
      | Ali4 | 44  | Istanbul4 |
      | Ali5 | 45  | Istanbul5 |