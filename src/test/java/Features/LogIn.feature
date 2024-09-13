Feature:
  Scenario: Log in to your WordPress site
    Given I am at wordpress homepage
    And I click on login link
    And I enter the valid Email
    And click on continue enter
    And I enter valid password
    When I click on login Button
    Then I am able to successfully log in

    Scenario: Check whether the “WP Dark Mode” Plugin is Active or not.
      Given I am at wordpress homepage
      And I click on login link
      And I enter the valid Email
      And click on continue enter
      And I enter valid password
      And I click on login Button
      And I am able to successfully log in
      And I click on plugins link
      And I type WP Dark Mode in search edit box from plugin page
      And I click on search icon from plugin page
      And I am able to see WP Dark Mode in search result page
      And I click on wp dark mode item from search result page
      And I click on Upgrade and active button
      And I click on new button
      And I enter postalcode and click on continue
      And I enter card holder name
      And I enter valid card number
      And I enter card expire date
      And I enter security code
      When I click on pay now button