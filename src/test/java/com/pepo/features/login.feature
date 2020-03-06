Feature: Start with First Android



  Scenario: Login with Twitter scenario
    Given User is ready to Login
    When User login with twitter credentials
    Then User should be logged in successfully
    And User should able to navigate to profile page
    Then User should able to navigate to notification page and accept the terms page


  Scenario: Login with Github scenario
    Given User is ready to Login
    When User login with gmail credentials
    Then User should be logged in successfully

  Scenario: Login with Gmail scenario
    Given User is ready to Login
    When User login with github credentials
    Then User should be logged in successfully

#
#  Scenario: Send Pepo
#    Given User should be on home page
#    When User sends 1 pepo heart on video
#    Then User should be asked to authorised device

