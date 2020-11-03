@ignore
Feature: Login on linkedIn

  Background: 
    Given Launch webbrowser and eLearning website

  @signinLinkedIn
  Scenario Outline: SignIn
    When LinkedIn Username "<uname>" entered
    And  LinkedIn Password "<password>" entered

    Examples: 
      | username    | pass        |
      | satwadde101 | satwadde101 |
