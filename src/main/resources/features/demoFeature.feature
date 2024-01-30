Feature: Test scenarios

  Scenario: Verify logout
    Given navigate to login-screen
    When login to jewel
    Then verify Logout button visibility
    And click and verify logout button