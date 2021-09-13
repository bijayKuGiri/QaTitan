Feature: Validate the carousel

  Scenario: Verifying carousel available
    Given The site is Up and Running
    When verifying the carousel rotation
    Then it should be work as expected