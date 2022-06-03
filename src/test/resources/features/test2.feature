
Feature: Values in the list-group div Test 2

  Background: pre-condition:
    And user is on a home page
    And user scrolls into view of Test 2 div

  Scenario: Verify if three values in the list-group div Test 2
    Then verify List Item 1 2 3 are displayed

  Scenario:  Verify list item's value
    Then verify "second" list item value is "List Item 2"

  Scenario:Verify list item's badge
    Then verify "second" list item badge is 6


