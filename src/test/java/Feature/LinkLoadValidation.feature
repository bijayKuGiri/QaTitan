Feature: Validate the hyperlink validation

  Scenario: Verifying Hyperlink loading time
    Given The site is Up and Running
    When i try to get the header links
    Then All the header link should load within 5 second