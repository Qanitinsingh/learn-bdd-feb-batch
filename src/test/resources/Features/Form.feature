Feature: Verify the form submission functionality on QA Automation Labs testing page

  Background:
    Given the user opens the "https://testing.qaautomationlabs.com/index.php" page

  @SmokeTest
  Scenario: User fills out and submits the form, then verifies the submission
    When the user navigates to the "https://testing.qaautomationlabs.com/form.php" page
    And the user fills out the form with valid data
      | FirstName | MiddleName | LastName | Email | Password | Address | City | State | Pin |
      | Nitin | Singh | Mohali | nitin@example.com | password123 | 123 Main St | Mohali | Punjab | 140501 |
    And the user submits the form
    Then the user verifies that a success message is displayed
    And the browser is closed