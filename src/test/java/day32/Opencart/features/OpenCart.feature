Feature:  Open cart tests

  # tüm senaryolardan önce otomatik calisir.Scenario:

  Background: go to homepage
    Given user navigate to "https://opencart.abstracta.us/"

  Scenario: Search for mac
    When  user search for "mac"
    Then  listed product number soud be 4

  Scenario: Search for tablet
    When  user search for "tablet"
    Then  listed product number soud be 0