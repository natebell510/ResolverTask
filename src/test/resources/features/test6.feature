@resolver @test6
Feature: Web table navigation

  Background:
    When user is on a home page
    And user scrolls into view of Test 6 div

  Scenario: Verify cell value at row 1 column 1
    And user checks value at cell at row 1 column 1
    Then cell value is "Carswell"

  Scenario: Verify cell value at row 2 column 2
    And user checks value at cell at row 2 column 2
    Then cell value is "Ventosanzap"





