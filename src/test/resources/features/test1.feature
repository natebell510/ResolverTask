Feature: Sample Login

  Background: user is on a home page

  Scenario:Navigate to the home page
    Then verify title of the page is "Home"

  Scenario: verify Sign in button, Email and Password input boxes are displayed.
    Then verify input box "Email address" is Displayed
    And verify input box "Password" is Displayed
    And verify "Sign in" button is Displayed

  Scenario:Enter email address and password
    When  user enters valid email in format: "*@*.*"
    And user enter valid "password" as any combination of letters and digits
    And use clicks "Sign in" button
    Then No error message is displayed


  Scenario: Enter email address and no password
    When  user enters valid email in format: "*@*.*"
    And user leaves password box empty
    And use clicks "Sign in" button
    Then input boxes can not be empty

  Scenario: Enter no email address and no password
    When user leaves email box empty
    And user leaves password box empty
    And user clicks "Sign in" button
    Then input boxes can not be empty




