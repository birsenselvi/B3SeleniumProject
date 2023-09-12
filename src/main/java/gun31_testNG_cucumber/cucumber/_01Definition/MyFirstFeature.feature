Feature: Bu feature ile ilgili
  Detayli aciklamalar yazilabilir
  As a user, I want to login, so that I can change my password
  As a user, I want to sum 2 numbers, so that I can see the result

  Scenario: Matematiksel islemler 1
    Given basangic sayisi 2
    When  bu sayiya 3 ekledigimde
    And   bu sayiya 4 ekledigimde
    Then  sonuc 10 olmali
    And   sonuc uygun
    And   netice "olumlu" olmali
    And   sonuc ALI olmali

  Scenario: Scenario 2
    Given basangic sayisi 0
    When  bu sayiya 1 ekledigimde
    And   bu sayiya 2 ekledigimde
    *     bu sayiya 3 ekledigimde
    *     bu sayiya 5 ekledigimde
    Then  sonuc 11 olmali