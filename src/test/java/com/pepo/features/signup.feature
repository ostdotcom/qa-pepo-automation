Feature: User sign up for the first time

  Background: Rotate user to new signup
    Given User is not part of Pepo


    Scenario: Activate new user and transfer pepo
      Given User is ready to signup in app via twitter
      When User authorised with twitter credentials
      And User will setup and confirm PIN
      Then User should navigate to feed page
      And Wallet activation should start
      When Wallet activation is completed
      Then User has balance of 500 pepos
      When User sends one pepo to video
      Then Transaction should completed successfully