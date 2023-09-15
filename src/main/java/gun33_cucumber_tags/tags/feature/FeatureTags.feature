  # tag Fature ve Scenario'lara verilir
  # Feature'a verilen tag bütün senaryolara eklenmis sayilir
  # Tag'lar istege göre isimlendirilebilir
  # Runner.class'da CucumberOptions icinde "tags" ile hangi taglarin run edilecegi belirtilir

@genel
Feature: Tags sasda sdasd asd asd asd asda sd
  asd asd asd asd asd asd asd asd sa

  @smoke @temp
  Scenario: Scenario 1
    Given tags scenario 1 step 1
    When  tags scenario 1 step 2
    Then  tags scenario 1 step 3


  @smoke @regression
  Scenario: Scenario 2
    Given tags scenario 2 step 1
    When  tags scenario 2 step 2
    Then  tags scenario 2 step 3

  @regression
  Scenario: Scenario 3
    Given tags scenario 3 step 1
    When  tags scenario 3 step 2
    Then  tags scenario 3 step 3