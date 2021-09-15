Feature: Validate the footer hyperlink validation

  Scenario: Verifying foot Hyperlink loading time
    Given The site is Up & Running
    When i try to get the footer links
    Then All the footer link should load within 5 second