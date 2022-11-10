Feature: Login to Guru99 Page

  Background:
    Given User is on Guru99Login page "https://demo.guru99.com/test/newtours/"

  @ValidCredentials
  Scenario: Login with valid credentials

    When User enters username as "tutorial" and password as "tutorial"
    Then User should be able to login successfully and new page open

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples:
      | username  | password   | errorMessage        |
      | tutorial1 | tutorial1  | Enter your userName and password correct |
      | tutorial2 | tutorial#@ | Enter your userName and password correct |