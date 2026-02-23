Feature: Test Home Page of the Application
  Background:
    Given User is on the "https://alphabetaops.com/" in Chrome

  @SmokeTest
  Scenario: Test Practice form submission
    When User clicks on the Novice Link
  And I click on Basic form present under Practice Form Option
  And I Switch to Iframe
    And User fills the form with following details
      | Username        | nitin01                    |
      | Password        | Pass@123                   |
      | Comments        | Automation tester          |
      | Gender          | Male                       |
      | Skills          | Java,Selenium              |
      | Experience      | 1-2 Years                  |
      | AutomationTools | Selenium,Playwright        |
      | ResumePath      | testdata/resume1.pdf       |
    And I click on submit button
    Then Form should be submitted successfully

