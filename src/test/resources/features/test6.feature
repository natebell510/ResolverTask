Feature: Web table navigation

  Background: user is on a home page

  Scenario: Find the value of the cell at specific coordinates
    When user scrolls into view of Test 6 div
    And user checks value at cell at row 0 column 1
    Then cell value is "Tinmouth"

  Scenario: Verify cell value at row 2 column 2
    When user scrolls into view of Test 6 div
    And user checks value at cell at row 2 column 2
    Then cell value is "Ventosanzap"

