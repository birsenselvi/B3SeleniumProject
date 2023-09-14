Feature: Scenario outline

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


  Scenario: scenario 3
    Given so my name is "ahmet"
    When  so my age is 50
    Then  so my country is "Ankara"



  # scenario outline da en altta bir adet Example: bölümü olmali
  # farkli datalar ile ayni senaryonun run edilmesi icin kullanilir
  # example'daki her bir satir icin senaryo tekrar edilir
  # example'da ilk satir basliktir
  @so
  Scenario Outline: scenario outline
    Given so my name is "<name>"
    When  so my age is <age>
    Then  so my country is "<city>"

    Examples:
      | name  | age | city     |
      | Ahmet | 50  | Ankara   |
      | Ali   | 34  | Istanbul |
      | Veli  | 45  | Adana    |

  @so2
  Scenario Outline: scenario outline 2
    Given so scenario <scenariono> step <stepno1>
    When  so login with the following data
      | username | <username> |
      | password | <password> |
    Then so scenario <scenariono> step <stepno2>

    Examples:
      | scenariono | stepno1 | stepno2 | username | password |
      | 1          | 1       | 3       | admin    | pass1    |
      | 2          | 1       | 3       | user     | pass2    |
      | 3          | 1       | 3       | demo     | pass3    |

