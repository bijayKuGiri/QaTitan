Feature: Validate the TermOfUse link

  Scenario: Verifying TermsOfUse link navigation
    Given The site is Up and Running
    And Navigate to Contact US Page
    When i try to click on TermOfUse link
    Then the page should redirect to TermOfUse page