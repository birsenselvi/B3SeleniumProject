

Feature: Open cart tests

  Scenario: Search for mac
    Given user navigate to "http://opencart.abstracta.us/"
    When  user search for "mac"
    Then  listed product number should be 4


  Scenario: Search for tablet
    Given user navigate to "http://opencart.abstracta.us/"
    When  user search for "tablet"
    Then  listed product number should be 0


  Scenario: Search for Apple
    Given user navigate to "http://opencart.abstracta.us/"
    When  user search for "Apple"
    Then  listed product number should be 1

