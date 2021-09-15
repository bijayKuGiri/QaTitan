Feature: Validate the facebook link

  Scenario: Verifying facebook link navigation
    Given The site is Up and Running
    When i try to click on facebook link
    Then the page should redirect to facebook page