@resolver @test5
Feature: Button visibility

  Scenario: Verify button is present and disabled after click
    When user is on a home page
    And user scrolls into view of Test 5 div
    And user should see a message "A button will eventually show up here..."
    And user waits for a button to be displayed and click on a button
    And user should see a message "You clicked a button!" after click
    Then verify button div is disabled
