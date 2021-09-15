Feature: Validate the PrivacyNotice link

  Scenario: Verifying PrivacyNotice link navigation
    Given The site is Up and Running
    And Navigate to ContactUS Page
    When i try to click on PrivacyNotice link
    Then the page should redirect to PrivacyNotice page