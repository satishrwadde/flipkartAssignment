@ignore
Feature: Flipkart

  Background: 
    Given Launch webbrowser and eLearning website

  @flipkartItems
  Scenario Outline: flipkart items
    When Flipkart getitems