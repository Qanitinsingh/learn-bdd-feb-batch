Feature: Left sidebar navigation on QA Automation Labs testing page

  Background:
    Given the user opens the "https://testing.qaautomationlabs.com/index.php" page

  @SmokeTest
  Scenario: User clicks each left-side menu item in a single browser session and verifies every page
    Then the user verifies all left-sidebar menu items one by one
    And the browser is closed