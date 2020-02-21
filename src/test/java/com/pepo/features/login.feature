Feature: Start with First Android



  Scenario: Login with Twitter scenario
    Given Launch the Pepo App
    When User login with twitter login
    Then User should be logged in successfully
    And User should able to navigate to profile page
    Then User should able to navigate to notification page and accept the terms page


  Scenario: Login with Github scenario
    Given Launch the Pepo App
    When User login with twitter login
    Then User should be logged in successfully

  Scenario: Login with Gmail scenario
    Given Launch the Pepo App
    When User login with twitter login
    Then User should be logged in successfully

#
#
#
#  Scenario: Profile verification
#    Given User should be on home page
#    When User navigate to profile page
#    Then verify user profile
#
#
#
#  Scenario: Send Pepo
#    Given User should be on home page
#    When User sends 1 pepo heart on video
#    Then User should be asked to authorised device


