Feature: Validate the CookiesNotice link

  Scenario: Verifying CookiesNotice link navigation
    Given The site is Up and Running
    And Navigate to Contactus Page
    When i try to click on CookiesNotice link
    Then the page should redirect to CookiesNotice page