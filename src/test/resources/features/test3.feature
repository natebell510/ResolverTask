Feature: Verify selected option and select a new one
  #Background is applied to all scenarios in feature file
  Background: user is on a home page

  Scenario: Verify default selected value in Test 3 div
    And user scrolls into view of Test 3 div
    Then verify that "Option 1" is selected by default


  Scenario:Select options from the select list
    And user scrolls into view of Test 3 div
    And user clicks on "Option 1" to get options
    And from dropdown menu user clicks on "Option 3"
    Then verify that "Option 3" is selected



