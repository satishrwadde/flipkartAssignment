Feature: Flipkart Feature

  Background: 
    Given Launch webbrowser and then flipkart website

  Scenario Outline: Finding highest , lowest priced & most popular watches
    When User search product in search box
    Then Filter for "<idealFor>" using ideal for option
    And Filter using "<watchBrand>"
    And Select filter using price filter "<minPrice>"
    And Select filter sort by "<sortBy>"
    And Get the price of first item
    And Capture headline from product page
    And Capture screenshot of product page

    Examples: 
      | idealFor | watchBrand | minPrice | sortBy      |
      | Men      | Fossil     |    10000 | High to Low |
      | Women    | Titan      |      500 | Low to High |
      | Boys     | Maxima     |      500 | Popularity  |
