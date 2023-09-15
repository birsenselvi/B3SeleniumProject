Feature: Soucedemo logen feature

  Scenario Outline: login
    Given sd user navigate to homepage
    When sd user try to login with the following credentials
      | username | "<username>" |
      | password | "<password>" |
    Then login should be "successfull"

    Examples:
      | username      | password     | result |
      | standard_user | secret_sauce | true   |
      | admin         | password     | false  |
      | problem_user  | secret_sauce | true   |