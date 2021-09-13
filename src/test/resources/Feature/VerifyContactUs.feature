Feature: Validate Contact Us

  Scenario: Verifying contact us page
    Given The site is Up and Running
    When navigate to contact us page and fill the details
    Then user should able to send the details