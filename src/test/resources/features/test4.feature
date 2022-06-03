@resolver @test4
Feature: Verify left and right button at Test 4 div

  Background: pre-condition:
    And user is on a home page
    And user scrolls into view of Test 4 div


  Scenario: Verify left button is enabled
    #And user clicks on left button
    Then verify button is enabled
    And rgb color value is "rgba(0, 123, 255, 1)" Blue


  Scenario: Verify right button is disabled in Test 4 div
    #And user clicks on right button
    Then verify button is disabled
    And rgb color value is "rgba(134, 142, 150, 1)" Grey



